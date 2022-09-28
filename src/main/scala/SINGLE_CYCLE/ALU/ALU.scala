package practice

import chisel3._ 
import chisel3.util._ 
import ALUOP1_._

object ALUOP1_ {
    val ALU_ADD = 0.U(5.W)
    val ALU_ADDI = 0.U(5.W)
    val ALU_SW = 0.U(5.W)
    val ALU_LW = 0.U(5.W)
    val ALU_SLL = 1.U(5.W)
    val ALU_SLLI = 1.U(5.W)
    val ALU_SLT = 2.U(5.W)
    val ALU_SLTI = 2.U(5.W)
    val ALU_SLTU = 3.U(5.W)
    val ALU_SLTUI = 3.U(5.W)
    val ALU_XOR = 4.U(5.W)
    val ALU_XORI = 4.U(5.W)
    val ALU_SRL = 5.U(5.W)
    val ALU_SRLI = 5.U(5.W)
    val ALU_OR  = 6.U(5.W)
    val ALU_ORI  = 6.U(5.W)
    val ALU_AND = 7.U(5.W)
    val ALU_ANDI = 7.U(5.W)
    val ALU_SUB = 8.U(5.W)
    val ALU_SRA = 13.U(5.W)
    val ALU_JAL = 31.U(5.W)
    val ALU_JALR = 31.U(5.W)
}
trait Config_{
    val WLEN = 32
    val ALUOP_SIG_LEN = 5
}
class ALU_1 extends Module with Config_ {
    val io = IO(new Bundle{
        val in_A = Input( SInt(WLEN.W) )
        val in_B = Input( SInt(WLEN.W) )
        val alu_Op = Input( UInt(ALUOP_SIG_LEN.W) )
        val out = Output( SInt(WLEN.W) )
})
val out = 
    Mux(io.alu_Op === ALU_ADD || io.alu_Op === ALU_ADDI || io.alu_Op === ALU_SW || io.alu_Op === ALU_LW, (io.in_A + io.in_B),
    Mux(io.alu_Op === ALU_SLL || io.alu_Op === ALU_SLLI, (io.in_A.asUInt << io.in_B(18, 0).asUInt).asSInt,
    Mux(io.alu_Op === ALU_SLT || io.alu_Op === ALU_SLTI, Mux(io.in_A < io.in_B, 1.S, 0.S),
    // Mux(io.alu_Op === ALU_SLT || io.alu_Op === ALU_SLTI, (io.in_A < io.in_B).asSInt
    // Mux(io.alu_Op === ALU_SLTU || io.alu_Op === ALU_SLTUI, (io.in_A.asUInt < io.in_B.asUInt).asSInt,
    Mux(io.alu_Op === ALU_SLTU || io.alu_Op === ALU_SLTUI, Mux(io.in_A < io.in_B, 1.S, 0.S),
    Mux(io.alu_Op === ALU_XOR || io.alu_Op === ALU_XORI, (io.in_A ^ io.in_B),
    Mux(io.alu_Op === ALU_SRL || io.alu_Op === ALU_SRLI, (io.in_A.asUInt >> io.in_B(18, 0).asUInt).asSInt,
    Mux(io.alu_Op === ALU_OR || io.alu_Op === ALU_ORI, (io.in_A | io.in_B),
    Mux(io.alu_Op === ALU_AND || io.alu_Op === ALU_ANDI, (io.in_A & io.in_B),
    Mux(io.alu_Op === ALU_SUB, (io.in_A - io.in_B),
    Mux(io.alu_Op === ALU_SRA, (io.in_A.asUInt >> io.in_B(18, 0).asUInt).asSInt,
    Mux(io.alu_Op === ALU_JAL || io.alu_Op === ALU_JALR, io.in_A, 0.S)))))))))))

io.out := out
}