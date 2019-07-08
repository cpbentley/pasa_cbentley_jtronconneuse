package pasa.cbentley.jtronconneuse.client;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import pasa.cbentley.jtronconneuse.common.ConfigChange;
import pasa.cbentley.jtronconneuse.ctx.JTroncoCtx;

public class JTroncoClientConnectionListener extends Listener {

   public JTroncoClientConnectionListener(JTroncoCtx jtc) {

   }

   public void connected(Connection connection) {
   }

   
   /**
    * Message recieved from the JTronco Server
    */
   public void received(Connection connection, Object object) {
      if (object instanceof ConfigChange) {
         ConfigChange configChange = (ConfigChange) object;

         return;
      }
   }

   public void disconnected(Connection connection) {

   }
}
