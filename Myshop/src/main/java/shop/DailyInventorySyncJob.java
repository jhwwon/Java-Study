package shop;

public class DailyInventorySyncJob implements BatchJob { 
	@Override 
	public void execute() {
		AppConfig cfg = AppConfig.getInstance(); 
		System.out.println("DailyInventorySyncJob 실행 - APP_TITLE=" + AppConfig.APP_TITLE + ", cfg@"
				+ System.identityHashCode(cfg));
	}
}

