CREATE (Pavel: Person {name: "Pavel", from:"Belarus"}), (Denis:
Person {name: "Denis", from: "Ukraine"}), (Maks:
Person {name: "Maks", from: "Poland"});

MATCH(Pavel:Person), (Denis:Person)
  WHERE Pavel.name = 'Pavel' AND Denis.name = 'Denis'
CREATE(Denis)-[:BE_FRIEND]->(Pavel);

MATCH(Pavel:Person), (Denis:Person)
  WHERE Pavel.name = 'Pavel' AND Denis.name = 'Denis'
CREATE(Pavel)-[:BE_FRIEND]->(Denis);

MATCH(Pavel:Person), (Maks:Person)
  WHERE Pavel.name = 'Pavel' AND Maks.name = 'Maks'
CREATE(Maks)-[:BE_FRIEND]->(Pavel);

MATCH(Pavel:Person), (Maks:Person)
  WHERE Pavel.name = 'Pavel' AND Maks.name = 'Maks'
CREATE(Pavel)-[:BE_FRIEND]->(Maks);

MATCH(Denis:Person), (Maks:Person)
  WHERE Denis.name = 'Denis' AND Maks.name = 'Maks'
CREATE(Maks)-[:BE_FRIEND]->(Denis);

MATCH(Denis:Person), (Maks:Person)
  WHERE Denis.name = 'Denis' AND Maks.name = 'Maks'
CREATE(Denis)-[:BE_FRIEND]->(Maks);

CREATE (Nike_Jordan: Trainers {Company: "Nike", from:"USA"}),
(Adidas_Equipment: Trainers {Company: "Adidas", from: "England"}),
(Puma_Clyde: Trainers {Company: "Puma", from: "Germany"});

MATCH(Pavel:Person), (Adidas: Trainers)
  WHERE Pavel.name = 'Pavel' AND Adidas.Company = 'Adidas'
CREATE(Pavel)-[:LIKE]->(Adidas);

MATCH(Pavel:Person), (Puma: Trainers)
  WHERE Pavel.name = 'Pavel' AND Puma.Company = 'Puma'
CREATE(Pavel)-[:LIKE]->(Puma);

MATCH(Pavel:Person), (Nike:
Trainers)
  WHERE Pavel.name = 'Pavel' AND Nike.Company = 'Nike'
CREATE(Pavel)-[:HAVE]->(Nike);

MATCH(Maks:Person), (Adidas: Trainers)
  WHERE Maks.name = 'Maks' AND Adidas.Company = 'Adidas'
CREATE(Maks)-[:LIKE]->(Adidas);

MATCH(Maks:Person), (Puma: Trainers)
  WHERE Maks.name = 'Maks' AND Puma.Company = 'Puma'
CREATE(Maks)-[:HAVE]->(Puma);

MATCH(Maks:Person), (Nike:
Trainers)
  WHERE Maks.name = 'Maks' AND Nike.Company = 'Nike'
CREATE(Maks)-[:LIKE]->(Nike);

MATCH(Denis:Person), (Adidas: Trainers)
  WHERE Denis.name = 'Denis' AND Adidas.Company = 'Adidas'
CREATE(Denis)-[:HAVE]->(Adidas);

MATCH(Denis:Person), (Puma: Trainers)
  WHERE Denis.name = 'Denis' AND Puma.Company = 'Puma'
CREATE(Denis)-[:LIKE]->(Puma);

MATCH(Denis:Person), (Nike:
Trainers)
  WHERE Denis.name = 'Denis' AND Nike.Company = 'Nike'
CREATE(Denis)-[:LIKE]->(Nike);

