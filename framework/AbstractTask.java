package scripts.NoobAccountLeveler.framework;
/**
 * 
 * @author Einstein
 *
 *
 */
public interface AbstractTask {

	String info();

	boolean shouldExecute();

	void execute();

}