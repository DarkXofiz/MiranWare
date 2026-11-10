// Original binary: sg/ec/fYMS7puAdLO05vFg
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// $VF: Compiled from s
public enum ModuleManager implements ModuleRegistry {
   INSTANCE;

   private final SortableArrayList<ToggleableModule> field19040 = new SortableArrayList<>();
   private final Map<Class<? extends ToggleableModule>, ToggleableModule> field19041 = new HashMap<>();
   private ArmorDurabilityView field19042;
   private SoundsVisualization field19043;
   private AntiLevitation field19044;
   private ProjectileHelper field19045;
   private ContainerHelper field19046;
   private SwingAnimations field19047;
   private ScoreBoardHealth field19048;
   private ItemHighlighter field19049;
   private NoFriendDamage field19050;
   private Beautification field19051;
   private WayPoints field19052;
   private ElytraBooster field19053;
   private AutoExplosion field19054;
   private CrystalOptimizer field19055;
   private LowDurabilityWarn field19056;
   private ServerHelper field19057;
   private ClientHelper field19058;
   private ElytraTarget field19059;
   private ElytraHelper field19060;
   private ElytraMotyaon field19061;
   private SeeInvisible field19062;
   private NoSlotChange field19063;
   private ServerJoiner field19064;
   private JumpCircle field19065;
   private RareGrabber field19066;
   private SpearStrafe field19067;
   private Trails field19068;
   private ChinaHat field19069;
   private Constellation field19070;
   private WindStreaks field19071;
   private WorldHelper field19072;
   private CustomHands field19073;
   private AutoTpaccept field19074;
   private AutoDropper field19075;
   private StreamerMode field19076;
   private PearlTarget field19077;
   private AutoCrystal field19078;
   private CrystalAura field19079;
   private AutoRespawn field19080;
   private FireWorkESP field19081;
   private WardenESP field19082;
   private KillMessage field19083;
   private DiscordRpcModule field19084;
   private IRC field19085;
   private MaceHelper field19086;
   private AutoAnchor field19087;
   private AutoPotion field19088;
   private NoSlow field19089;
   private ClickPearl field19090;
   private ItemHelper field19091;
   private AttackAura field19092;
   private KillEffect field19093;
   private BetterChat field19094;
   private AutoSprint field19095;
   private FullBright field19096;
   private ItemPhysics field19097;
   private AuctionHelper field19098;
   private AutoBuy field19099;
   private AutoTotem field19100;
   private AutoArmor field19101;
   private AntiCrash field19102;
   private AutoLever field19103;
   private Particles field19104;
   private BetterTab field19105;
   private Criticals field19106;
   private TargetESP field19107;
   private EntityESP field19108;
   private Crosshair field19109;
   private ViewModel field19110;
   private TapeMouse field19111;
   private LegitMode field19112;
   private WallClimb field19113;
   private GrimGlide field19114;
   private Scaffold field19115;
   private Searcher field19116;
   private AutoKeyFinder field19117;
   private NoClip field19118;
   private ServerRPSpoof field19119;
   private AutoSwap field19120;
   private FreeLook field19121;
   private BlockESP field19122;
   private ClickGUI field19123;
   private Velocity field19124;
   private Removals field19125;
   private AutoTool field19126;
   private Ambience field19127;
   private AutoDuel field19128;
   private AirStake field19129;
   private NoTrace field19130;
   private FreeCam field19131;
   private NoDelay field19132;
   private AntiBot field19133;
   private WebTrap field19134;
   private InventoryMove field19135;
   private Arrows field19136;
   private Flight field19137;
   private DragonFly field19138;
   private NoPush field19139;
   private AntiThorns field19140;
   private AimBot field19141;
   private Timer field19142;
   private Panic field19143;
   private Blink field19144;
   private Nuker field19145;
   private NoWeb field19146;
   private Hud field19147;

   public void method08164() {
      this.method08165();
      KeyBindingManager.INSTANCE.method11745(this);
   }

   private void method08165() {
      this.method08166(this.field19042 = new ArmorDurabilityView());
      this.method08166(this.field19043 = new SoundsVisualization());
      this.method08166(this.field19044 = new AntiLevitation());
      this.method08166(this.field19045 = new ProjectileHelper());
      this.method08166(this.field19047 = new SwingAnimations());
      this.method08166(this.field19048 = new ScoreBoardHealth());
      this.method08166(this.field19049 = new ItemHighlighter());
      this.method08166(this.field19046 = new ContainerHelper());
      this.method08166(this.field19051 = new Beautification());
      this.method08166(this.field19052 = new WayPoints());
      this.method08166(this.field19050 = new NoFriendDamage());
      this.method08166(this.field19054 = new AutoExplosion());
      this.method08166(this.field19055 = new CrystalOptimizer());
      this.method08166(this.field19053 = new ElytraBooster());
      this.method08166(this.field19064 = new ServerJoiner());
      this.method08166(this.field19057 = new ServerHelper());
      this.method08166(this.field19059 = new ElytraTarget());
      this.method08166(this.field19060 = new ElytraHelper());
      this.method08166(this.field19061 = new ElytraMotyaon());
      this.method08166(this.field19058 = new ClientHelper());
      this.method08166(this.field19063 = new NoSlotChange());
      this.method08166(this.field19062 = new SeeInvisible());
      this.method08166(this.field19056 = new LowDurabilityWarn());
      this.method08166(this.field19068 = new Trails());
      this.method08166(this.field19069 = new ChinaHat());
      this.method08166(this.field19070 = new Constellation());
      this.method08166(this.field19071 = new WindStreaks());
      this.method08166(this.field19078 = new AutoCrystal());
      this.method08166(this.field19079 = new CrystalAura());
      this.method08166(this.field19086 = new MaceHelper());
      this.method08166(this.field19087 = new AutoAnchor());
      this.method08166(this.field19077 = new PearlTarget());
      this.method08166(this.field19073 = new CustomHands());
      this.method08166(this.field19072 = new WorldHelper());
      this.method08166(this.field19076 = new StreamerMode());
      this.method08166(this.field19067 = new SpearStrafe());
      this.method08166(this.field19065 = new JumpCircle());
      this.method08166(this.field19074 = new AutoTpaccept());
      this.method08166(this.field19075 = new AutoDropper());
      this.method08166(this.field19080 = new AutoRespawn());
      this.method08166(this.field19083 = new KillMessage());
      this.method08166(this.field19084 = new DiscordRpcModule());
      this.method08166(this.field19085 = new IRC());
      this.method08166(this.field19066 = new RareGrabber());
      this.method08166(this.field19081 = new FireWorkESP());
      this.method08166(this.field19082 = new WardenESP());
      this.method08166(this.field19089 = new NoSlow());
      this.method08166(this.field19091 = new ItemHelper());
      this.method08166(this.field19088 = new AutoPotion());
      this.method08166(this.field19092 = new AttackAura());
      this.method08166(this.field19095 = new AutoSprint());
      this.method08166(this.field19096 = new FullBright());
      this.method08166(this.field19097 = new ItemPhysics());
      this.method08166(this.field19090 = new ClickPearl());
      this.method08166(this.field19093 = new KillEffect());
      this.method08166(this.field19094 = new BetterChat());
      this.method08166(this.field19113 = new WallClimb());
      this.method08166(this.field19098 = new AuctionHelper());
      this.method08166(this.field19099 = new AutoBuy());
      this.method08166(this.field19100 = new AutoTotem());
      this.method08166(this.field19101 = new AutoArmor());
      this.method08166(this.field19105 = new BetterTab());
      this.method08166(this.field19111 = new TapeMouse());
      this.method08166(this.field19110 = new ViewModel());
      this.method08166(this.field19106 = new Criticals());
      this.method08166(this.field19107 = new TargetESP());
      this.method08166(this.field19108 = new EntityESP());
      this.method08166(this.field19103 = new AutoLever());
      this.method08166(this.field19104 = new Particles());
      this.method08166(this.field19112 = new LegitMode());
      this.method08166(this.field19114 = new GrimGlide());
      this.method08166(this.field19115 = new Scaffold());
      this.method08166(this.field19109 = new Crosshair());
      this.method08166(this.field19102 = new AntiCrash());
      this.method08166(new AutoTrap());
      this.method08166(new Speed());
      this.method08166(this.field19116 = new Searcher());
      this.method08166(this.field19119 = new ServerRPSpoof());
      this.method08166(this.field19123 = new ClickGUI());
      this.method08166(this.field19120 = new AutoSwap());
      this.method08166(this.field19125 = new Removals());
      this.method08166(this.field19124 = new Velocity());
      this.method08166(this.field19126 = new AutoTool());
      this.method08166(this.field19128 = new AutoDuel());
      this.method08166(this.field19121 = new FreeLook());
      this.method08166(this.field19127 = new Ambience());
      this.method08166(this.field19129 = new AirStake());
      this.method08166(this.field19122 = new BlockESP());
      this.method08166(this.field19130 = new NoTrace());
      this.method08166(this.field19134 = new WebTrap());
      this.method08166(this.field19131 = new FreeCam());
      this.method08166(this.field19133 = new AntiBot());
      this.method08166(this.field19132 = new NoDelay());
      this.method08166(this.field19135 = new InventoryMove());
      this.method08166(this.field19141 = new AimBot());
      this.method08166(this.field19137 = new Flight());
      this.method08166(this.field19138 = new DragonFly());
      this.method08166(this.field19139 = new NoPush());
      this.method08166(this.field19140 = new AntiThorns());
      this.method08166(this.field19136 = new Arrows());
      this.method08166(this.field19143 = new Panic());
      this.method08166(this.field19142 = new Timer());
      this.method08166(this.field19144 = new Blink());
      this.method08166(this.field19146 = new NoWeb());
      this.method08166(this.field19145 = new Nuker());
      this.method08166(this.field19117 = new AutoKeyFinder());
      this.method08166(this.field19118 = new NoClip());
      this.method08166(new NoFall());
      this.method08166(this.field19147 = new Hud());
      this.field19040.method00237(ToggleableModule::method03925);
   }

   @Override
   public void method05140(ToggleableModule var1) {
      this.field19040.add(var1);
      this.field19041.put((Class<? extends ToggleableModule>)var1.getClass(), var1);
   }

   public void method08166(ToggleableModule var1) {
      this.method05140(var1);
   }

   public void method08167(ToggleableModule var1) {
      this.field19040.remove(var1);
      if (this.field19041.get(var1.getClass()) == var1) {
         this.field19041.remove(var1.getClass());
      }
   }

   @Override
   public <T extends ToggleableModule> T method05142(Class<T> var1) {
      return (T)(Object)var1.cast(this.field19041.get(var1));
   }

   @Override
   public ToggleableModule method05141(String var1) {
      for (ToggleableModule var3 : this.field19040) {
         if (var3.method03925().equalsIgnoreCase(var1)) {
            return var3;
         }
      }

      return null;
   }

   @Override
   public List<ToggleableModule> method05139(ModuleCategory var1) {
      ArrayList var2 = new ArrayList();

      for (ToggleableModule var4 : this.field19040) {
         if (var4.method03938() == var1) {
            var2.add(var4);
         }
      }

      return var2;
   }

   @Override
   public SortableArrayList<ToggleableModule> method05138() {
      return this.field19040;
   }

   public Map<Class<? extends ToggleableModule>, ToggleableModule> method08168() {
      return this.field19041;
   }

   public ArmorDurabilityView method08169() {
      return this.field19042;
   }

   public SoundsVisualization method08170() {
      return this.field19043;
   }

   public AntiLevitation method08171() {
      return this.field19044;
   }

   public ProjectileHelper method08172() {
      return this.field19045;
   }

   public ContainerHelper method08173() {
      return this.field19046;
   }

   public SwingAnimations method08174() {
      return this.field19047;
   }

   public ScoreBoardHealth method08175() {
      return this.field19048;
   }

   public ItemHighlighter method08176() {
      return this.field19049;
   }

   public NoFriendDamage method08177() {
      return this.field19050;
   }

   public Beautification method08178() {
      return this.field19051;
   }

   public WayPoints method08179() {
      return this.field19052;
   }

   public ElytraBooster method08180() {
      return this.field19053;
   }

   public AutoExplosion method08181() {
      return this.field19054;
   }

   public CrystalOptimizer method08182() {
      return this.field19055;
   }

   public LowDurabilityWarn method08183() {
      return this.field19056;
   }

   public ServerHelper method08184() {
      return this.field19057;
   }

   public ClientHelper method08185() {
      return this.field19058;
   }

   public ElytraTarget method08186() {
      return this.field19059;
   }

   public ElytraHelper method08187() {
      return this.field19060;
   }

   public ElytraMotyaon method08188() {
      return this.field19061;
   }

   public SeeInvisible method08189() {
      return this.field19062;
   }

   public NoSlotChange method08190() {
      return this.field19063;
   }

   public ServerJoiner method08191() {
      return this.field19064;
   }

   public JumpCircle method08192() {
      return this.field19065;
   }

   public RareGrabber method08193() {
      return this.field19066;
   }

   public SpearStrafe method08194() {
      return this.field19067;
   }

   public Trails method08195() {
      return this.field19068;
   }

   public ChinaHat method08196() {
      return this.field19069;
   }

   public Constellation method08197() {
      return this.field19070;
   }

   public WindStreaks method08198() {
      return this.field19071;
   }

   public WorldHelper method08199() {
      return this.field19072;
   }

   public CustomHands method08200() {
      return this.field19073;
   }

   public AutoTpaccept method08201() {
      return this.field19074;
   }

   public AutoDropper method08202() {
      return this.field19075;
   }

   public StreamerMode method08203() {
      return this.field19076;
   }

   public PearlTarget method08204() {
      return this.field19077;
   }

   public AutoCrystal method08205() {
      return this.field19078;
   }

   public CrystalAura method08206() {
      return this.field19079;
   }

   public AutoRespawn method08207() {
      return this.field19080;
   }

   public FireWorkESP method08208() {
      return this.field19081;
   }

   public WardenESP method08209() {
      return this.field19082;
   }

   public KillMessage method08210() {
      return this.field19083;
   }

   public DiscordRpcModule method08211() {
      return this.field19084;
   }

   public IRC method08212() {
      return this.field19085;
   }

   public MaceHelper method08213() {
      return this.field19086;
   }

   public AutoAnchor method08214() {
      return this.field19087;
   }

   public AutoPotion method08215() {
      return this.field19088;
   }

   public NoSlow method08216() {
      return this.field19089;
   }

   public ClickPearl method08217() {
      return this.field19090;
   }

   public ItemHelper method08218() {
      return this.field19091;
   }

   public AttackAura method08219() {
      return this.field19092;
   }

   public KillEffect method08220() {
      return this.field19093;
   }

   public BetterChat method08221() {
      return this.field19094;
   }

   public AutoSprint method08222() {
      return this.field19095;
   }

   public FullBright method08223() {
      return this.field19096;
   }

   public ItemPhysics method08224() {
      return this.field19097;
   }

   public AuctionHelper method08225() {
      return this.field19098;
   }

   public AutoBuy method08226() {
      return this.field19099;
   }

   public AutoTotem method08227() {
      return this.field19100;
   }

   public AutoArmor method08228() {
      return this.field19101;
   }

   public AntiCrash method08229() {
      return this.field19102;
   }

   public AutoLever method08230() {
      return this.field19103;
   }

   public Particles method08231() {
      return this.field19104;
   }

   public BetterTab method08232() {
      return this.field19105;
   }

   public Criticals method08233() {
      return this.field19106;
   }

   public TargetESP method08234() {
      return this.field19107;
   }

   public EntityESP method08235() {
      return this.field19108;
   }

   public Crosshair method08236() {
      return this.field19109;
   }

   public ViewModel method08237() {
      return this.field19110;
   }

   public TapeMouse method08238() {
      return this.field19111;
   }

   public LegitMode method08239() {
      return this.field19112;
   }

   public WallClimb method08240() {
      return this.field19113;
   }

   public GrimGlide method08241() {
      return this.field19114;
   }

   public Scaffold method08242() {
      return this.field19115;
   }

   public Searcher method08243() {
      return this.field19116;
   }

   public AutoKeyFinder method08244() {
      return this.field19117;
   }

   public NoClip method08245() {
      return this.field19118;
   }

   public ServerRPSpoof method08246() {
      return this.field19119;
   }

   public AutoSwap method08247() {
      return this.field19120;
   }

   public FreeLook method08248() {
      return this.field19121;
   }

   public BlockESP method08249() {
      return this.field19122;
   }

   public ClickGUI method08250() {
      return this.field19123;
   }

   public Velocity method08251() {
      return this.field19124;
   }

   public Removals method08252() {
      return this.field19125;
   }

   public AutoTool method08253() {
      return this.field19126;
   }

   public Ambience method08254() {
      return this.field19127;
   }

   public AutoDuel method08255() {
      return this.field19128;
   }

   public AirStake method08256() {
      return this.field19129;
   }

   public NoTrace method08257() {
      return this.field19130;
   }

   public FreeCam method08258() {
      return this.field19131;
   }

   public NoDelay method08259() {
      return this.field19132;
   }

   public AntiBot method08260() {
      return this.field19133;
   }

   public WebTrap method08261() {
      return this.field19134;
   }

   public InventoryMove method08262() {
      return this.field19135;
   }

   public Arrows method08263() {
      return this.field19136;
   }

   public Flight method08264() {
      return this.field19137;
   }

   public DragonFly method08265() {
      return this.field19138;
   }

   public NoPush method08266() {
      return this.field19139;
   }

   public AntiThorns method08267() {
      return this.field19140;
   }

   public AimBot method08268() {
      return this.field19141;
   }

   public Timer method08269() {
      return this.field19142;
   }

   public Panic method08270() {
      return this.field19143;
   }

   public Blink method08271() {
      return this.field19144;
   }

   public Nuker method08272() {
      return this.field19145;
   }

   public NoWeb method08273() {
      return this.field19146;
   }

   public Hud method08274() {
      return this.field19147;
   }
}
