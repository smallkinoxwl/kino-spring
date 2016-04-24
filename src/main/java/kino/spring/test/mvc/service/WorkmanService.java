package kino.spring.test.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public interface WorkmanService {

	public List<Map<String, Object>> getWorkmanInfo(int i,String s);

}
