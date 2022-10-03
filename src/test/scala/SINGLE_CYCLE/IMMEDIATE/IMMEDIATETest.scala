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
   }
}      
}
