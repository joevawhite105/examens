package examens;

import java.util.HashSet;
import java.util.Set;
import logicalcollections.LogicalSet;
/**
 * @invar | getExamens() != null
 * @invar | getExamens().stream().allMatch(e -> e != null && e.getLokalen().contains(this))
 */
public class Lokaal {
	/**
	 * @representationObject
	 * @peerObjects
	 * @invar | examens != null
	 * @invar | examens.stream().allMatch(e -> e != null && e.lokalen.contains(this))
	 */
	 Set<Examen> examens = new HashSet<>(); 
    /**
     * @post | getExamens().isEmpty()
     */
	
	Set<Examen> getExamensInternal(){
		return Set.copyOf(examens);
	}
	public Lokaal() {}
	/**
	 * @peerObjects
	 * @creates | result
	 */
	public Set<Examen> getExamens() {return Set.copyOf(examens);}


}
