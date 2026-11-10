// Original binary: hex/api/baritone/api/command/registry/Registry
package hex.api.baritone.api.command.registry;

import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

// $VF: Compiled from s
public class Registry<V> {
   private final Deque<V> _entries = new LinkedList<>();
   private final Set<V> registered = new HashSet<>();
   public final Collection<V> entries = Collections.unmodifiableCollection(this._entries);

   public boolean registered(V var1) {
      return this.registered.contains(var1);
   }

   public boolean register(V var1) {
      if (!this.registered(var1)) {
         this._entries.addFirst(var1);
         this.registered.add(var1);
         return true;
      } else {
         return false;
      }
   }

   public Stream<V> descendingStream() {
      return StreamSupport.stream(Spliterators.spliterator(this.descendingIterator(), this._entries.size(), 16448), false);
   }

   public Iterator<V> iterator() {
      return this._entries.iterator();
   }

   public void unregister(V var1) {
      if (this.registered(var1)) {
         this._entries.remove(var1);
         this.registered.remove(var1);
      }
   }

   public Iterator<V> descendingIterator() {
      return this._entries.descendingIterator();
   }

   public Stream<V> stream() {
      return this._entries.stream();
   }
}
