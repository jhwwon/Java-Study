package shop;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BatchRunner {
	public static void main(String[] args) {
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
		ses.scheduleAtFixedRate(() -> safeRun(new DailyInventorySyncJob()), 0, 30, TimeUnit.SECONDS);
		ses.scheduleAtFixedRate(() -> safeRun(new DataExportJob()), 5, 30, TimeUnit.SECONDS);
		System.out.println("배치가 실행 중입니다. (종료: Ctrl+C)");
	}

	private static void safeRun(BatchJob job) {
		try {
			job.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}