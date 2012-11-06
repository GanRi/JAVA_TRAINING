package ch17.ex05;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;


public final class ResourceManager {

	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs;
	boolean shutdown = false;
	
	
	public ResourceManager() {
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>, Resource>();
		// ... initialize resources ...
	}
	
	
	public synchronized void shutdown() {
		if (!shutdown) {
			shutdown = true;
			//reaper.interrupt();
			clearRef();
		}
	}
	
	
	public synchronized Resource getResource(Object key) {
		if (shutdown)
			throw new IllegalStateException();
		Resource res = new ResourceImpl(key);
		Reference<?> ref =
			new PhantomReference<Object>(key, queue);
		refs.put(ref, res);
		
		clearRef();
		
		return res;
	}
	
	public synchronized void clearRef(){
		Reference<?> keyRef = queue.poll();
		if(keyRef != null){
			Resource resource = null;
	
			resource = refs.get(keyRef);
			refs.remove(keyRef);
	
			resource.release();
			keyRef.clear();
		}
	}
	
	
	
	private static class ResourceImpl implements Resource {
		Reference<?> keyRef;
		boolean needsRelease = false;
		
		ResourceImpl(Object key) {
			keyRef =new WeakReference<Object>(key);
			// .. set up the external resource
			needsRelease = true;
		}
		
		
		public void use(Object key, Object... args) {
			if(keyRef.get() == null || keyRef.get() != key)
				throw new IllegalArgumentException("wrong key");
			// ... use the resource ...
		}
		
		
		public synchronized void release() {
			if (needsRelease) {
				needsRelease = false;
				// .. release the resource ...
			}
		}
		
	}
}