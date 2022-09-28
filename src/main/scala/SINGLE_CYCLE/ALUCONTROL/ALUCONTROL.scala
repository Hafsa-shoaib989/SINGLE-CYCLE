package practice

import chisel3._
import chisel3.util._
 
class Alu_Control ( ) extends Module {
    val io = IO (new Bundle {
        val func3 = Input ( UInt (3.W ) )
        val func7 = Input ( Bool () )
        val aluOp = Input ( UInt (3.W ) )
        val out = Output ( UInt ( 5.W ) )
})
// R type
when (io.aluOp === 0.U) {
    io.out := Cat(0.U, io.func7, io.func3)

// I type
}.elsewhen (io.aluOp === 1.U) {
    io.out := Cat(0.U, 0.U, io.func3)

// S type
}.elsewhen (io.aluOp === 5.U) {
    io.out := Fill(5, 0.U)

// SB type
}.elsewhen (io.aluOp === 2.U) {
    io.out := Cat(1.U, 0.U, io.func3)
// U type
}.elsewhen (io.aluOp === 7.U) {
    io.out := Cat(0.U, io.func7, io.func3)

// UJ type
}.elsewhen (io.aluOp === 3.U) {
    io.out := Fill(5, 1.U)

}otherwise{
    io.out := 0.U
}
}