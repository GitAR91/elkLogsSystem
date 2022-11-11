Spring project sample to collect and view log scenarios for any request by ID

Project structure:
  1) Main api sample (elkLogSystem)
  2) (optional) Third-party api for testing collecting logs scenarios from both api (thirdPartyApi)
  3) (optional) Worker for testing collecting logs in kafka broker (worker)
  4) Elasticsearch for storing logs
  5) Logstash for delivery logs from api to ES
  6) Kibana for visualize response objects statistics
  7) Zookeeper and kafka broker to delive main api messages to worker
  
 Getting start:
  To run project put "docker-compose up" (docker-compose up -d)
  	or
  Applications can be run separately
  	docker-compose up -d logs-application (also run zookeeper and kafka)
  	docker-compose up -d logs-third-party
  	docker-compose up -d logs-worker
  	docker-compose up -d elasticsearch
  	docker-compose up -d logstash
  	docker-compose up -d kibana
  	
  Collect log scenarios:
  Main application checks every request on pre-handle filter for RequestId header and put it's value to MDC for logginning
  if there is no such header, it is created automatically (UUID)
  
  Each processing log for this request will include requestID. Also, rsponse (even with error) will consist such header too
  To browse request log scenario check it on localhost:8080/logs/ by requestId
  
  Collect response objects IDs:
  For logginning each object's ID returned in the response put @LogObjectId annotation on required controller
  
  	IMPORTANT: each object model for use with the annotation must contain a "getId" method (implements LoggingObj interface)
  Finaly we will get a log with id of each object returned in the response (objects may be both single("SomeObject") and collectable(List<SomeObj>, Collection<SomeObj>, Page<SomeObj>))
  
  
