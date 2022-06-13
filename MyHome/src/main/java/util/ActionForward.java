package util;

//페이지 이동을 관리하는 클래스
public class ActionForward {
	private String nextPath;
	private boolean isRedirect; 
	
	public ActionForward(String nextPath,boolean isRedirect) {
		this.nextPath = nextPath;
		this.isRedirect = isRedirect;
	}

	public String getNextPath() {
		return nextPath;
	}

	public void setNextPath(String nextPath) {
		this.nextPath = nextPath;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}
