package pasa.cbentley.jtronconneuse.server;

import com.esotericsoftware.kryonet.Connection;

import pasa.cbentley.jtronconneuse.ctx.JTroncoCtx;

public class JTroncoConnection extends Connection {

   private JTroncoCtx jtc;

   private String     name2;

   private JTroncoServer server;

   public JTroncoConnection(JTroncoCtx jtc, JTroncoServer server, String name) {
      this.jtc = jtc;
      this.server = server;
      name2 = name;

   }
}
