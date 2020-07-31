this project is practice project for hibernate and jpa that use spring boot to run
there is a summery for this project
I collectthem for interview

spring.h2.console.enabled=true to enabale h2 console
spring.datasource.url=jdbc:h2:mem:testdb the url should set

ddl command to create table
	create table person(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key(id)
	);

insert command
	insert into PERSON(ID,NAME,LOCATION,BIRTH_DATE) values(10001,'SINA','TEHRAN',sysdate());
	
@Repository
public class PersonJdbcDao

@Autowired
JdbcTemplate jdbcTemplate

use row mapper to map table columns to class  new BeanPropertyRowMapper<Person>

step 6
CommanLineRunner to run spring application in console
to log in console we use slf4j logger sample :
	private Logger logger = LoggerFactory.getLogger(this.getClass());



in jdbc 
1-get Connection
2-ccreate statement
3-statement.executeQuery
4-get values indivisually from result set and add to the list
5-close connecction
6-return list
7-we must handle exceptions to not allow connection be opened

mistakes reduces in springJDBC

make logging in application.properties
logging.level.root=debug

maintain application with jdbc or jdbsTemplate is hard mapping is hard so jpa comes

hibernate iplements JPA

@Entity
@Table(name="tableName")
@Id indicates it is primary key
@GeneratedValue base on sequence created in database create a value
we need no argument constructor 
we creae a constructor without id


step 15:
to create jpa repository 
1-we must say it is a repository with @Repository annotation
2-when we need update or delete in 2 or 3 steps in a single transaction we want 
all of them be successful or all of them to fail so we need @Transactional 
3-to connect to data base we need EntityManager that manages all operations in specefic session entities to store in data base
4-all the operations stores in @PersistenceContext
entityManager is interface to the persistence context

entities in data base	

step 18
entityManager have diffrent methods find(Person.class,id)
merge(person); if have id updates and if not have id create person
remove(person); to remove person
to find all persons we use NamedQuery hql
entityManager.namedQuery("namedQuery",Person.class)
returns TypedQuery<Person> typedQuery
typedQuery.getResultList() return List of users


for test in spring :
1-use @RunWith(SpringRunner.class)
2-use @SpringBootTest(classes = SpringJdbcApplication.class) to specify the main class that have @SpringBootApplication
3-declare test method with @Test test method must return void
4-inject what need and with assertEqual do test

to log use with slf4j use this on method
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	logger.info("this is test for log");
	
	sample:
		Course course = courseRepo.findById(10001l);
		assertEquals("Simple jpa sample 1",course.getName());

if we add @Trabsactional to a class all methods would be transactional
and if one step fails then other steps not running

to test deleteById we shuld use assertNull method to check
when use some tests like delete we use @DirtessContext to reset data to use other tests

when use @Transactional the entire method works in a transaction and
while we are in scope of transaction entity manager keeps track of all 
the things that where updated or inserted through it 
entity manager keep track of all the objects that managed through in transactional method and whenever change data it sure save in data base


em.flush() :
	save changes in database
em.detach(entity)	
 	detach enity from entityManage so not save in database
em.clear()
	detach all entites in entityManager and
	after clear entities no reflect to data base 	
em.refresh(entity)
	contents of entity refreshed and data would be 
	accourding data in database 	

 
jpql query from entities
sql query from tables

EntityManager.createQuery("select c from course c").getResultList(); return raw data

EntityManager.createQuery("select c from course c",Course.class).getResultList(); return  Course list


Annotations:
	@Table(name="Course") in class specify name of table
	@Column(name="") in field specify name of column
	@Column(name="",nullable=false) name cannot be null value
	 diffrent att:	
		 	unique
			nullable
			insertable
			length defalt 255
			persicion


@CreationTimestamp
a hibernate annotation when create set time stamp

@UpdateTimestamp
a hibernate annotation when update automatically update database

named query prevent hardcode queries
with @NamedQuery in the name of class
can specify name and query
@NamedQueries for multible queries

to update many rows we have to use native queies

to create one to one relationship
@OneToOne
private Class class

in the method we have to pesist child object then persist owner side to save one to one relashenship

any one to one relattonship always eager by default so fetch related object from table a left  outer join always call

in oneToOne relationship if set fetch to FetchType.lazy we should add @Transactional in method when we use retrive to not close Hibernate Session


in oneToOne relationship to make bi directional we use mappedBy attribute in the second class;


in a method that have @transactional 
hibernate wait until the end of the block and save changes to database 
until if we use flush() method;


to establish oneToMany relationship for example one review can have zero or multiple 
reviews so the realationship in review is oneToMany and in course class is ManyToOne 
the owner of relationship is review and course_id is review table
so mapped by attribute shuld put in Course class in ManyToOne annotaton.


when we want to add members to a oneToMany relathinship we must
1-add list members in OneToMany side and set member in oneToMany side
2-use em.persist to save oneToMany side in database

in ManyToMany relashinship we have to stablish a join table 

when we add ManyToMany annotation in two side hibernate make 2join tables
to fix this problem we must 
1-define owner side of relationship
2-then add mappedBy to other side

we can define @JoinTable in the owner side of manyToMany reltionship
JoinTable have 3 attributes name JoinColumns and reverseJoinColumns

ManyToMany relationship is use lazy fetch type by default

when insert a manytomany relationship 
we use sample code like bellow
	
		
		Course course = em.find(Course.class, courseId);
		Student student = em.find(Student.class, studentId);
		student.addCourse(course);
		course.addStudent(student);
		
		em.persist(student);
		em.persist(course);


default strategy in inheritence is Single_Table
wecan add @Inheritance(strategy=InheritenceType.SINGLE_TYPE)
there is just one employee table 
subclass types saves in a table for performance its goot because we save 
and retrive all data in a table
but in perspective of data integrity its nott good because some columns left
empty(null) there is chance that there is invalid data that come
we can have alot of nullable column in single table hirarchi

@descriminatorColumn can specify type 

other strategy is TABEL_PER_CLASS
for each concreat sub classes it create a table
it is good in perspective of performance and integrity
but common columns are repeated in both tables

inheritenceType.joined each class parent and subclasses are seprated
and with foregin key they can relate to each other
to get details we have use join to join tables

last option is not use Inheritance annotation
we use @MappedSuperclass it cannot use @Entity 

jpql samples

	select curses where there is no student
	
	in objective manner it is simple 
					   :
			   select c from Course c where c.students is empty 
			   	
 	
 	some hpqls:
 		select c from Course c where size(c.students)>2
 		select c from Course c order by size(c.students) desc
 		select s from student s where s.passport.number like '%1%'
 		
 	to join to tables with hql 
 			: select c,s from Course c JOIN c.students s 
 		left join :select c,s from Course c left JOIN c.students s 
 		
 		
sample use Critria

		1)CriteriaBuilder cb = em.getCriteriaBuilder();
		2)CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		3)Root<Course> courseRoot = cq.from(Course.class);
		
		
		4)Query query = 
				em.createQuery(cq.select(courseRoot));
		
		5)List resultList = query.getResultList();
		logger.info("select c from Course c {}",resultList); 				
			
sample use criteria with where like

//		select c from Course c where c.name like %jpa%
//		1)use criteriaBuilder to create criteriaQuery base on object
		CriteriaBuilder cb =em.getCriteriaBuilder();
		
		CriteriaQuery<Course> criteriaQuery = cb.createQuery(Course.class);
		
//		2)define root for table which are involved
		Root<Course> courseRoot = criteriaQuery.from(Course.class);
		
//		3)define predicates etc using citeria builder
		Predicate likePredicate =cb.like(courseRoot.get("name"), "%jpa%");
		criteriaQuery.where(likePredicate);
		
		
		TypedQuery<Course> query =  em.createQuery(criteriaQuery.select(courseRoot));
		List<Course> resultList = query.getResultList();			
		
		logger.info("typed query {} ",resultList);
		
		
sample 2 criteria  courses without student
//		select c from Course c where c.students is empty 
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
		
		
		Root<Course> courseRoot = criteriaQuery.from(Course.class);
		
		Predicate isEmptyPredicate = 	criteriaBuilder.isEmpty(courseRoot.get("students"));
		
		criteriaQuery.where(isEmptyPredicate);
		
		TypedQuery<Course> query = em.createQuery(criteriaQuery.select(courseRoot));
	
		List<Course> resultList = query.getResultList();
		
		logger.info("typed query {} ",resultList);






ACID properties in transaction management
		A=Atomicity either a transaction should be completely successful or
		all the changes that are done by transaction should be reverted
		
		C Concurrent or concurrency
		it should not matter how many other transactions are running parallel
		it should give same result as executing transaction on its own
		so you should be able execute multiple transactions concurrently
		it means if you execute parallel or one after another the result should be  same
		
		
		
		I isolation
		is not one definit thing there are multiple levels of isolation that are present isolation means how changes within transaction is visible to the other transactions
		
		
		d durability
		once a transaction is successful then if the system crashes or somthing wrong happens the data should be persistent
		

3 concept in isolation level
	1)Dirty read
		when a transaction to read of value which was modified by transaction 
		one beforethe transaction one is commited
	2)Non repeatable read
	 	when a transaction tries to read the same data twice and it get two
	 	diffrent values during the same transaction
	3)phantom read		
		i get diffrent number of rows as a result of queryat two diffrent 
		points of transaction
		



spring data jpa is one implementation of jpa

to create spring data repository we have to create interface
that extends JpaRepository<Course,Long>

	springDataRepository have diffrent  methods such as findById that returns Optional   value and other methods like findAll and countAll and ...
	
	
	
for pagging in spring data 
	use pageRequest like this code snippet
	
		PageRequest pageRequest = PageRequest.of(0, 3);
		Page<Course> firstPage = courseRepo.findAll(pageRequest);
		logger.info("first page {}",firstPage.getContent());
	for next page we should request like this
		Pageable secondPageable = firstPage.nextPageable();
		Page<Course> secondPage = courseRepo.findAll(secondPageable);
		logger.info("second page {}",secondPage.getContent());
			
in the interface that extend JpaRepository<Course,Long>
we can define method interfaces to spring create related methods for us.

	for example
		public interface CourseSpringDataRepository extends JpaRepository<Course, Long>{
	List<Course> findByName(String name);
	List<Course> countByName(String name);
	List<Course> findByNameAndId(String name,Long id);
	List<Course> findByNameOrderByNameDesc(String name);
	List<Course> deleteByName(String name);
	
	@Query("select c from Course c where name like '%jpa'")
	List<Course> coursesWithnameLikeJpa();
	
	@Query(value="select * from Course c where name like '%jpa'",
			nativeQuery = true)
	List<Course> coursesWithnameLikeJpaNativeQuery();
	
	@Query(name = "get_all_jpa_courses")
	List<Course> coursesWithnamedQuery();
	
}

to use spring data rest
	we have to add spring data rest to pom.xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-rest</artifactId>
		</dependency>

then we had to add @RepositoryRestResource to this class
CourseSpringDataRepository and we can specify a path to this annotation


some data for example user name will not change frequently
and we need get this data frequently in each page so we need cache this user information in data layer  every time
there not need to retrive data from database

in hibernate there is 2 level of cashe
first level and secon level of cashing

cahing:instead of retrive data from database for every query for data that will not change frequently we would cash it and use it from cash 

first level cashe is data that is basically to a single transaction
so within a single transaction if you are requesting for the same data again first level cashe comes in to picture

the second level cashe comes into picture for data which is common across multiple 
users  

if in a method there is have @Transactional annotation so the requested entities cashed and 
the second request read data from cashe not from database;
most important thing about first level cashe is the boundry of transaction
first level cashe is active by default

we use ehcahe for second level cache
to add second level cashe use ehcashe
1)add related dependency
2)add this property to application.properties
	spring.jpa.properties.hibernate.cache.use_second_level_casche=true
3)specify how to do cashing
	#specifing how to do cashing
spring.jpa.properties.hibernate.cache.region.factory_class=org.hibernate.cache.ehcache.EhCacheRegionFactory

4)only cache what i say cache
		spring.jpa.properties.javax.persistence.sharedCache.mode=ENABLE_SELECTIVE
		diffrent options:ALL,NONE,ENABLE_SELECTIVE,DISABLE_SELECTIVE	
 

5)add @Cacheable to a class to cach properties of class

we can add @SqlDelete to add soft delete facility
to do this 

1)add this field to Entity class private boolean isDeleted;
2)add related IS_DELETE field to data base
3)add @SqlDelete annotation to Entity class 
4)add sql attribute to @SqlDelete annotation like this "update course set is_deleted=true where id=?"
5) add @Where annotation to get rows where not soft deleted and are active
for example @Where(clause = "id_deleted=false")

@Where annotation does not apply for native queries.

@PreRemove
is annotation for before executing remove function


@PostLoad
the marked method would be called as soon as the entity is retrived and loaded
so there is select query fired and entity is being loadedthis specific method would be call

@PostPersist   @PrePersist
when you call the entityManager.persist()  the method that anootated with this annotation
is called
@PostRemove	@PreRemove
after delete an entity this method calls
@PostUpdate	@PreUpdate
after an update fire to an entity


if we want have an entity inside our entity but havent another table
actually embedded Class
the new class have to had @Embedable annotation
and on the field add @Embed annotation to field 

to connect to other databases
1)add related dependencies to pom .xml
	for mysql database
		add this dependency:
			<dependency>
				<groupId>mysql</groupId>
				<artifactId>mysql-connector-java</artifactId>
			</dependency>
2)config application.xml
	spring.jpa.hibernate.ddl-auto=none
	spring.datasource.url=jdbc:mysql://localhost:3306/person_example
	spring.datasource.username=personuser
	spring.datasource.password=YOUR_PASSWORD			












