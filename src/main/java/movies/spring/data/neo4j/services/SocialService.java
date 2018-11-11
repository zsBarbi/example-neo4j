package movies.spring.data.neo4j.services;

import java.util.*;

import movies.spring.data.neo4j.domain.Person;
import movies.spring.data.neo4j.domain.Role;
import movies.spring.data.neo4j.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SocialService {

    private final static Logger LOG = LoggerFactory.getLogger(SocialService.class);

	private final PersonRepository personRepository;
	public SocialService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	private Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		result.put(key1, value1);
		result.put(key2, value2);
		return result;
	}

    @Transactional(readOnly = true)
    public Person findByName(String name) {
        Person result = personRepository.findByName(name);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<Person> findByTitleLike(String name) {
        Collection<Person> result = personRepository.findByNameLike(name);
        return result;
    }

  	/*
    @Transactional(readOnly = true)
  	public Map<String, Object>  graph(int limit) {
  		Collection<Movie> result = movieRepository.graph(limit);
  		return toD3Format(result);
  	}
    */
}
