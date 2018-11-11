package movies.spring.data.neo4j.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "FB_FRIEND")
public class Friend {

    @Id
    @GeneratedValue
	private Long id;

	@StartNode
	private Person person1;

	@EndNode
	private Person person2;

	public Friend() {
	}

	public Friend(Person p1, Person p2) {
		this.person1 = p1;
		this.person2 = p2;
	}

	public Long getId() {
	    return id;
	}

	public Person getPerson1() {
	    return person1;
	}

	public Person getPerson2() {
	    return person2;
	}
}
