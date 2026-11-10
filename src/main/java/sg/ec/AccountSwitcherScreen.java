package sg.ec;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import net.minecraft.client.User;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import sg.mx.MinecraftMixin;

public class AccountSwitcherScreen extends Screen implements MinecraftAccess {
   private static final int ROW_HEIGHT = 22;
   private static final int ROWS_PER_PAGE = 6;
   private final Screen parent;
   private final List<String> accounts = new ArrayList<>();
   private EditBox nameField;
   private String selected;
   private int page;
   private String status = "";

   public AccountSwitcherScreen(Screen parent) {
      super(Component.literal("Аккаунты"));
      this.parent = parent;
      this.load();
   }

   private static Path file() {
      return mc.gameDirectory.toPath().resolve("Hex").resolve("accounts.txt");
   }

   private void load() {
      this.accounts.clear();
      try {
         Path path = file();
         if (Files.exists(path)) {
            for (String line : Files.readAllLines(path, StandardCharsets.UTF_8)) {
               String name = line.trim();
               if (isValidName(name) && !this.accounts.contains(name)) {
                  this.accounts.add(name);
               }
            }
         }
      } catch (IOException ignored) {
      }
   }

   private void save() {
      try {
         Path path = file();
         Files.createDirectories(path.getParent());
         Files.write(path, this.accounts, StandardCharsets.UTF_8);
      } catch (IOException ignored) {
      }
   }

   private static boolean isValidName(String name) {
      return name != null && name.matches("[A-Za-z0-9_]{3,16}");
   }

   public static void login(String name) {
      UUID uuid = UUID.nameUUIDFromBytes(("OfflinePlayer:" + name).getBytes(StandardCharsets.UTF_8));
      User user = new User(name, uuid, "0", Optional.empty(), Optional.empty());
      if (BotSessionManager.INSTANCE.method08732()) {
         BotSessionManager.INSTANCE.method08731(user);
      } else {
         ((MinecraftMixin) mc).setSession(user);
      }
   }

   @Override
   protected void init() {
      int cx = this.width / 2;
      int top = 40;
      int listBottom = top + ROWS_PER_PAGE * ROW_HEIGHT;
      int pages = Math.max(1, (this.accounts.size() + ROWS_PER_PAGE - 1) / ROWS_PER_PAGE);
      this.page = Math.min(this.page, pages - 1);

      int from = this.page * ROWS_PER_PAGE;
      for (int i = from; i < Math.min(from + ROWS_PER_PAGE, this.accounts.size()); i++) {
         String name = this.accounts.get(i);
         String label = name.equals(mc.getUser().getName()) ? "> " + name + " <" : name;
         if (name.equals(this.selected)) {
            label = "[" + label + "]";
         }
         this.addRenderableWidget(Button.builder(Component.literal(label), b -> {
            if (name.equals(this.selected)) {
               this.doLogin(name);
            } else {
               this.selected = name;
               this.nameField.setValue(name);
               this.rebuildWidgets();
            }
         }).bounds(cx - 100, top + (i - from) * ROW_HEIGHT, 200, 20).build());
      }

      if (pages > 1) {
         this.addRenderableWidget(Button.builder(Component.literal("<"), b -> {
            this.page = (this.page - 1 + pages) % pages;
            this.rebuildWidgets();
         }).bounds(cx - 126, listBottom - ROW_HEIGHT * ROWS_PER_PAGE / 2 - 10, 20, 20).build());
         this.addRenderableWidget(Button.builder(Component.literal(">"), b -> {
            this.page = (this.page + 1) % pages;
            this.rebuildWidgets();
         }).bounds(cx + 106, listBottom - ROW_HEIGHT * ROWS_PER_PAGE / 2 - 10, 20, 20).build());
      }

      String old = this.nameField == null ? "" : this.nameField.getValue();
      this.nameField = new EditBox(this.font, cx - 100, listBottom + 8, 200, 20, Component.literal("Ник"));
      this.nameField.setMaxLength(16);
      this.nameField.setHint(Component.literal("Ник (3-16 символов)"));
      this.nameField.setValue(old);
      this.addRenderableWidget(this.nameField);

      int by = listBottom + 34;
      this.addRenderableWidget(Button.builder(Component.literal("Войти"), b -> this.doLogin(this.nameField.getValue().trim()))
         .bounds(cx - 100, by, 98, 20).build());
      this.addRenderableWidget(Button.builder(Component.literal("Добавить"), b -> {
         String name = this.nameField.getValue().trim();
         if (!isValidName(name)) {
            this.status = "Неверный ник";
         } else if (!this.accounts.contains(name)) {
            this.accounts.add(name);
            this.save();
            this.status = "Добавлен: " + name;
            this.rebuildWidgets();
         }
      }).bounds(cx + 2, by, 98, 20).build());
      this.addRenderableWidget(Button.builder(Component.literal("Удалить"), b -> {
         String name = this.selected != null ? this.selected : this.nameField.getValue().trim();
         if (this.accounts.remove(name)) {
            this.save();
            this.selected = null;
            this.status = "Удалён: " + name;
            this.rebuildWidgets();
         }
      }).bounds(cx - 100, by + 24, 98, 20).build());
      this.addRenderableWidget(Button.builder(Component.literal("Назад"), b -> this.onClose()).bounds(cx + 2, by + 24, 98, 20).build());
      this.setInitialFocus(this.nameField);
   }

   private void doLogin(String name) {
      if (!isValidName(name)) {
         this.status = "Неверный ник";
         return;
      }
      login(name);
      if (!this.accounts.contains(name)) {
         this.accounts.add(name);
         this.save();
      }
      this.selected = name;
      this.status = "Вошёл как " + name;
      this.rebuildWidgets();
   }

   @Override
   public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
      super.render(graphics, mouseX, mouseY, delta);
      int cx = this.width / 2;
      graphics.drawCenteredString(this.font, "Аккаунты", cx, 14, -1);
      graphics.drawCenteredString(this.font, "Текущий: " + mc.getUser().getName(), cx, 26, 0xFFAAAAAA);
      if (this.accounts.isEmpty()) {
         graphics.drawCenteredString(this.font, "Список пуст — введи ник и нажми «Добавить»", cx, 40 + ROW_HEIGHT * 2, 0xFF888888);
      }
      if (!this.status.isEmpty()) {
         graphics.drawCenteredString(this.font, this.status, cx, this.height - 16, 0xFF55FF55);
      }
   }

   @Override
   public void onClose() {
      mc.setScreen(this.parent);
   }
}
