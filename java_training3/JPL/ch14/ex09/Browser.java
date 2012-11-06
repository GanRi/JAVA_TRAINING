package ch14.ex09;

public class Browser {
	private static final int MAX_NUM = 10;
	
	public void startShowGroup(final ThreadGroup group){
		
		new Thread(new Runnable(){
		
					@Override
					public void run() {
						while(true){
							show(group, 0);
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.println();
						}
						
					}
					
				}, "Thread show group").start();	
	}
	
	public void show(ThreadGroup group, int level){
		printInfo("Group name: " + group.getName(), level);
		
		ThreadGroup[] directGroups = new ThreadGroup[MAX_NUM];
		group.enumerate(directGroups, false);
		for(ThreadGroup directGroup : directGroups){
			if(directGroup == null){
				break;
			}
			show(directGroup, level + 1);
		}
		
		
		Thread[] directThreads = new Thread[MAX_NUM];
		group.enumerate(directThreads, false);
		for(Thread directThread : directThreads){
			if(directThread == null){
				break;
			}
			printInfo("Thread name: " + directThread.getName() + ", Thread ID :" + directThread.getId(), level + 1);
		}	

	}
	
	private void printInfo(String info, int level){
		for(int i = 0; i < level; i++){
			System.out.print("  ");
		}
		System.out.println(info);
	}
	
	
	public static void main(String[] args){
//		final Browser browser = new Browser();
//		browser.show(Thread.currentThread().getThreadGroup(), 0);	
		
		
		ThreadGroup groupa = new ThreadGroup("GroupA");
		new Thread(groupa, new Run(3),"Threada_1(Groupa)").start();
		new Thread(groupa, new Run(5),"Threada_2(Groupa)").start();
		new Thread(groupa, new Run(7),"Threada_3(Groupa)").start();	
		
		ThreadGroup group1 = new ThreadGroup(groupa, "Group1");
		new Thread(group1, new Run(3),"Thread1_1(Group1)").start();
		new Thread(group1, new Run(5),"Thread1_2(Group1)").start();
		
		ThreadGroup group2 = new ThreadGroup(groupa, "Group2");
		new Thread(group2, new Run(4),"Thread2_1(Group2)").start();
		new Thread(group2, new Run(6),"Thread2_2(Group2)").start();	
		group2.setDaemon(true);
		
		final Browser browser = new Browser();
		browser.startShowGroup(groupa);
		
	}
}

