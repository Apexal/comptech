public interface Coder extends MessageDecoder, MessageEncoder {
	// This interface exists so that an array can be made that holds all of the Encoders/Decoders since they all share this interface.
}
