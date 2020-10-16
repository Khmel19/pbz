// 1
MATCH (p:Person)
  WHERE p.name = 'Pavel'
RETURN p;

// 2
MATCH (person)-[:LIKE]->(trainers)
  WHERE person.name = 'Maks'
RETURN trainers;

// 3 
MATCH (person)-[:LIKE]->(trainers)
  WHERE trainers.Company = 'Nike'
RETURN person.name;

// 4
MATCH (person)-[:HAVE]->(trainers)
  WHERE person.name = 'Pavel'
RETURN trainers.Company;

// 5 
MATCH (person)-[:LIKE]->(trainers)
  WHERE trainers.Company = 'Puma'
RETURN person.from;

// 6
MATCH (person)-[:HAVE]->(trainers)
  WHERE trainers.Company = 'Adidas'
RETURN person.name;

// 7
MATCH (s:Trainers)
  WHERE s.from = 'USA'
RETURN s;

// 8 
MATCH (person:Person)-[:BE_FRIEND]->(friend:Person)
RETURN friend;

// 9 
MATCH (person:Person)-[:BE_FRIEND]->(friend:Person)
WHERE person.name='Pavel'
RETURN friend;

// 10 
MATCH (person:Person)-[:BE_FRIEND]->(friend:Person)
WHERE friend.name='Pavel' OR friend.name='Denis'
RETURN person;