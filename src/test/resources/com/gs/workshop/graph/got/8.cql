
call apoc.load.jsonArray('https://raw.githubusercontent.com/joakimskoog/AnApiOfIceAndFire/master/data/houses.json') yield value
with apoc.convert.toMap(value) as data
with apoc.map.clean(data, [],['',[''],[],null]) as data
with apoc.map.fromPairs([k in keys(data) | [toLower(substring(k,0,1))+substring(k,1,length(k)), data[k]]]) as data
MERGE (h:House {id:data.id})
SET
h += apoc.map.clean(data, ['overlord','swornMembers','currentLord','heir','founder','cadetBranches'],['',[''],[],null])
FOREACH (id in data.swornMembers | MERGE (o:Person {id:id}) MERGE (o)-[:ALLIED_WITH]->(h))
FOREACH (s in data.seats | MERGE (seat:Seat {name:s}) MERGE (seat)-[:SEAT_OF]->(h))
FOREACH (id in data.cadetBranches | MERGE (b:House {id:id}) MERGE (b)-[:BRANCH_OF]->(h))
FOREACH (id in case data.overlord when null then [] else [data.overlord] end | MERGE (o:House {id:id}) MERGE (h)-[:SWORN_TO]->(o))
FOREACH (id in case data.currentLord when null then [] else [data.currentLord] end | MERGE (o:Person {id:id}) MERGE (h)-[:LED_BY]->(o))
FOREACH (id in case data.founder when null then [] else [data.founder] end | MERGE (o:Person {id:id}) MERGE (h)-[:FOUNDED_BY]->(o))
FOREACH (id in case data.heir when null then [] else [data.heir] end | MERGE (o:Person {id:id}) MERGE (o)-[:HEIR_TO]->(h))
FOREACH (r in case data.region when null then [] else [data.region] end | MERGE (o:Region {name:r}) MERGE (h)-[:IN_REGION]->(o))
return h.id, h.name;