package edu.eci.cvds.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;

import java.util.LinkedHashMap;
import java.util.Map;


@Service
public class ConfigurationService {
	
	private final ConfigurationRepository configurationRepository;
	
	@Autowired
	public ConfigurationService(ConfigurationRepository configurationRepository) {
		this.configurationRepository = configurationRepository;
	}
	
	public Configuration addConfiguration(Configuration configuration) {
		return configurationRepository.save(configuration);
	}
	
	public Configuration getConfiguration(String configurationId) {
		return configurationRepository.findById(configurationId).get();
	}
	
	public java.util.List<Configuration> getAllConfigurations() {
		return configurationRepository.findAll();
	}
	
	public Configuration updateConfiguration(Configuration configuration) {
		if(configurationRepository.existsById(configuration.getPropiedad())) {
			return configurationRepository.save(configuration);
		}
		
		return null;
	}
	
	public void deleteConfiguration(String configurationId) {
		configurationRepository.deleteById(configurationId);
	}	
}
 