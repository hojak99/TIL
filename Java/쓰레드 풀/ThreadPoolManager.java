import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManager {
	private static ThreadPoolManager sThreadPoolManager = new ThreadPoolManager();
	private static final int SIZE_CORE_POOL = 3;
	private static final int SIZE_MAX_POOL = 4;
	private static final int TIME_KEEP_ALIVE = 5000;
	private static final int SIZE_WORK_QUEUE = 500;
	private static final int PERIOD_TASK_QOS = 1000;
	private final Queue<Runnable> mTaskQueue = new LinkedList<Runnable>();
	
	
	public static ThreadPoolManager newInstance() {
		return sThreadPoolManager;
	}
	
	private final RejectedExecutionHandler mHandler = new RejectedExecutionHandler() {
		
		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			mTaskQueue.offer(r);
		}
	};
	
	private final Runnable mAccessBufferThread = new Runnable() {
		
		@Override
		public void run() {
//			if(hasMoreAcquire()) {
//				mThreadPool.execute(mTaskQueue.poll());
//			}
		}
	};
	
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	
	protected final ScheduledFuture<?> mTaskHandler = scheduler.scheduleAtFixedRate(
			mAccessBufferThread, 
			0, 
			PERIOD_TASK_QOS, 
			TimeUnit.MILLISECONDS
	);

	private final ThreadPoolExecutor mThreadPool = new ThreadPoolExecutor(
			SIZE_CORE_POOL, 
			SIZE_MAX_POOL, 
			TIME_KEEP_ALIVE, 
			TimeUnit.SECONDS, 
			new ArrayBlockingQueue<Runnable>(SIZE_WORK_QUEUE), 
			mHandler
	);
	
	private ThreadPoolManager() {
		
	}
	
	public void perpare() {
		if(mThreadPool.isShutdown() && !mThreadPool.prestartCoreThread()) {
				@SuppressWarnings("unused")
				int startThread = mThreadPool.prestartAllCoreThreads();
		}
	}
}
