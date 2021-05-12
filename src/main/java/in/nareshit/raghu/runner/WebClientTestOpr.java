package in.nareshit.raghu.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class WebClientTestOpr implements CommandLineRunner {


	public void run(String... args) throws Exception {
		WebClient client = WebClient.create("http://localhost:8686");

		//1. fetching all rows data
		/*
		Flux<Student> flux = 
				client.get()
				.uri("/student/all")
				.retrieve()
				.bodyToFlux(Student.class);


		flux.doOnNext(System.out::println).blockLast();
		 */

		//2. Get one row data
		/*
		Mono<Student> mono =
				client.get()
				//.uri("/student/find/{id}",11)
				.uri("/student/find/11")
				.retrieve()
				.bodyToMono(Student.class);

		mono.subscribe(System.out::println);
		 */

		//3. insert/update
		/*
		Mono<Student> mono =
				client.post()
				.uri("/student/save")
				.body(Mono.just(new Student(13, "RAM S", 600.0)), Student.class)
				.retrieve()
				.bodyToMono(Student.class);
		mono.subscribe(System.out::println);
		 */

		//4. delete 
		Mono<Void> mono =
				client.delete()
				.uri("/student/delete/12")
				.retrieve()
				.bodyToMono(Void.class);
		mono.subscribe(System.out::println);
		
		/*Mono<String> mono =
				client.delete()
				.uri("/student/delete/12")
				.retrieve()
				.bodyToMono(String.class);
		mono.subscribe(System.out::println);
		*/
	}

}
