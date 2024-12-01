package com.fiap.spring.batch.batch.config;

import com.fiap.spring.batch.batch.domain.Person;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {

    @Bean
    public Job processarPerson(JobRepository jobRepository, Step step) {
        return new JobBuilder("processarPerson", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    @Bean
    public Step step(
            JobRepository jobRepository,
            PlatformTransactionManager platformTransactionManager,
            ItemReader<Person> reader,
            ItemWriter<Person> writer,
            ItemProcessor<Person, Person> processor
    ) {
        return new StepBuilder("step", jobRepository)
                .<Person, Person>chunk(20, platformTransactionManager) // Qtd de registros que vai pegar em cada execução
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public ItemReader<Person> reader() {
        BeanWrapperFieldSetMapper<Person> mapper = new BeanWrapperFieldSetMapper<>();
        mapper.setTargetType(Person.class);

        return new FlatFileItemReaderBuilder<Person>()
                .name("personItemReader")
                .resource(new ClassPathResource("files/testfile.csv")) // Local do arquivo a partir do resources
                .delimited()
                .names("name", "streetName", "number", "city", "country", "email", "phoneNumber") // Nome das colunas do arquivo
                .fieldSetMapper(mapper)
                .linesToSkip(1) // Pula a primeira linha do header
                .build();
    }

    @Bean
    public ItemWriter<Person> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Person>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .dataSource(dataSource)
                .sql("""
                        INSERT INTO person (name, street_name, number, city, country, email, phone_number, create_date_time)
                        VALUES (:name, :streetName, :number, :city, :country, :email, :phoneNumber, :createDateTime)
                        """)
                .build();
    }

    @Bean
    public ItemProcessor<Person, Person> processor() {
        return new PersonProcessor();
    }
}