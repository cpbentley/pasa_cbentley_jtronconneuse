package pasa.cbentley.jtronconneuse.ctx;

import pasa.cbentley.core.src4.ctx.ACtx;
import pasa.cbentley.core.src4.ctx.UCtx;

public class JTroncoCtx extends ACtx {

   public JTroncoCtx(UCtx uc) {
      super(uc);
   }
   
   public int getPort() {
      return 54555;
   }

}
