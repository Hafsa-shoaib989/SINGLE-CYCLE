package practice

import chisel3._
import org.scalatest.FreeSpec
import chiseltest._

class IMMEDIATETest extends FreeSpec with ChiselScalatestTester{
   "IMMEDIATETest test" in{
       test(new Immde()){c =>
         c.io.instr.poke("h000022b7".U)
         c.io.pc.poke(0.U)
         c.clock.step(1) 
        //  c.io.I_type.expect(5.U)
        //  c.io.S_type.expect(5.U)
        //  c.io.SB_type.expect(2052.U)
         c.io.U_type.expect(8192.S)
        //  c.io.UJ_type.expect(2052.U)
   }
}      
}
