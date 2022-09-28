package practice

import chisel3._
import chisel3.util._

class DataMem ( ) extends Module {
    val io = IO (new Bundle {
        val addr = Input ( UInt (32.W ) )
        val dataIn = Input ( SInt (32.W ) )
        val mem_read = Input ( Bool () )
        val mem_write = Input ( Bool () )
        val dataOut = Output ( SInt ( 32.W ) )
})
val Sync_memory = SyncReadMem ( 32 , SInt ( 32.W ) )

when ( io.mem_write ) {
    Sync_memory.write ( io.addr , io.dataIn )
}
io.dataOut := Sync_memory.read ( io.addr , io.mem_read )
}

