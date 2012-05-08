package ch06.ex03;

public class VerboseImpl implements Verbose{

	Verbosity verbosity;
	@Override
	public Verbosity getVerbosity() {
		// TODO Auto-generated method stub
		return verbosity;
	}

	@Override
	public void setVerbosity(Verbosity verbosity) {
		// TODO Auto-generated method stub
		this.verbosity = verbosity;
	}

	
	public static void main(String[] args){
		Verbose verbose = new VerboseImpl();
		verbose.setVerbosity(Verbosity.SILENT);
		System.out.println(verbose.getVerbosity());
	}
}
