public interface MessageEncoder {
	public abstract void init();
	public abstract String encode(String plainText);
}
