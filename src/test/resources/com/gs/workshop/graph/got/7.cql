call apoc.load.jsonArray('https://raw.githubusercontent.com/joakimskoog/AnApiOfIceAndFire/master/data/characters.json') yield value
with apoc.convert.toMap(value) as data
with apoc.map.clean(data, [],['',[''],[],null]) as data
with apoc.map.fromPairs([k in keys(data) | [toLower(substring(k,0,1))+substring(k,1,length(k)), data[k]]]) as data
MERGE (p:Person {id:data.id})
SET
p += apoc.map.clean(data, ['allegiances','father','spouse','mother'],['',[''],[],null]),
p.name = coalesce(p.name,head(p.aliases))
FOREACH (id in data.allegiances | MERGE (h:House {id:id}) MERGE (p)-[:ALLIED_WITH]->(h))
FOREACH (id in case data.father when null then [] else [data.father] end | MERGE (o:Person {id:id}) MERGE (o)-[:PARENT_OF {type:'father'}]->(p))
FOREACH (id in case data.mother when null then [] else [data.mother] end | MERGE (o:Person {id:id}) MERGE (o)-[:PARENT_OF {type:'mother'}]->(p))
FOREACH (id in case data.spouse when null then [] else [data.spouse] end | MERGE (o:Person {id:id}) MERGE (o)-[:SPOUSE]-(p))
return p.id, p.name;