// package practice

// import chisel3._
// import org.scalatest.FreeSpec
// import chiseltest._

// class ALUTest extends FreeSpec with ChiselScalatestTester{
//    "ALUTest test" in{
//        test(new ALU_1 ()){c =>
//          c.io.in_A.poke(5.S)
//          c.io.in_B.poke(2.S)
//          c.io.alu_Op.poke(13.U)
//          c.clock.step(1) 
//          c.io.out.expect(1.S)
//    }
// }      
// }
