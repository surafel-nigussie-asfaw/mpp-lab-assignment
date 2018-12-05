package ea.mpp.library.data;

public interface IDAO<K, V> {
	public V add(K key, V value);
	public V update(K key, V value);
	public V get(K key);
	public V delete(K key);
}
