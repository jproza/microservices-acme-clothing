package ar.com.challenge.acme.clothing.repository;

import ar.com.challenge.acme.clothing.entities.Product;
import ar.com.challenge.acme.clothing.entities.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StockRepository extends MongoRepository<Stock, String> {



    List<Stock> findByLstStorage_NombreContainingIgnoreCase(String nombre);


//    List<Stock> findByNombreContainingIgnoreCase(String nombre);



//    @Query("{$lookup: {from : \"Families\", " +
//            "let: { names: \"$name\"}," +
//            " pipeline:[{ $match:\n" +
//            "                { $expr:\n" +
//            "                    { $and:\n" +
//            "                        [\n" +
//            "                           { $eq: [ \"$name\", \"$$names\"] },\n" +
//            "                        ]\n" +
//            "                    }\n" +
//            "                }\n" +
//            "            }],  as : \"Families\"}}")
    //@Query("{ $lookup: {from : \"products\", localField: \"familiaProduto\", foreignField: \"id\", as : \"name\"}},{ $match : { name: ?0}}} ")
    //@Query("{\"products.familiaProduto.id}, { products: { $elemMatch: { name: ?0 } }")
//
//    @Aggregation(pipeline = {" {\n" +
//            "        $lookup:\n" +
//            "        {\n" +
//            "            from: \"Families\",\n" +
//            "                    let: { product_name: \"$name\" },\n" +
//            "            pipeline: [\n" +
//            "            { $match:\n" +
//            "            { $expr:\n" +
//            "            { $and:\n" +
//            "                       [\n" +
//            "                { $eq: [ \"$name\",  \"?0\" ] }\n" +
//            "                       ]\n" +
//            "            }\n" +
//            "            }\n" +
//            "            },\n" +
//            "            { $project: { name: 0} }\n" +
//            "           ],\n" +
//            "            as: \"Families\"\n" +
//            "        }\n" +
//            "    }"})





//@Aggregation(pipeline = {"{$match:{'name' : { $eq: ?0}}}"})

//[{ $match:\n" +
//            "                { $expr:\n" +
//            "                    { $and:\n" +
//            "                        [\n" +
//            "                           { $eq: [ \"$name\", \"$$names\"] },\n" +
//            "                        ]\n" +
//            "                    }\n" +
//            "                }\n" +
////            "            }]
//@Aggregation(pipeline = {" {\n" +
//        "        $lookup:\n" +
//        "        {\n" +
//        "            from: \"Families\",\n" +
//        "                    let: { name: \"{?0}\" },\n" +
//        "            pipeline: [\n" +
//        "            {$match:{\"name\" : { $eq: \"familiaProduto.name\"}}},\n" +
//        "            { $project: { name: 0} }\n" +
//        "           ],\n" +
//        "            as: \"Families\"\n" +
//        "        }\n" +
//        "    }"})

//@Query("{\"familiaProduto.name\": {\"$eq\" : \"Familia1\"}}")
//@Query("{ $lookup: {from : \"Family\", as : \"p\"}},{ $match : { name: ?0}}} ")

//@Aggregation(pipeline = {" {\n" +
//        "        $lookup:\n" +
//        "        {\n" +
//        "            from: \"Families\",\n" +
//        "                    let: { name: \"{?0}\" },\n" +
//        "            pipeline: [\n" +
//        "            {$match:{\"name\" : { $eq: \"familiaProduto.name\"}}},\n" +
//        "            { $project: { name: 0} }\n" +
//        "           ],\n" +
//        "            as: \"Families\"\n" +
//        "        }\n" +
//        "    }"})
//List<Stock> findByFamiliaProduto_NameContains(String name) ;
//@Aggregation(pipeline = {"{ $lookup: { from: 'Families', let: { name: '$names' }, pipeline: [{ $match: { $expr: { $and: [ { $eq: ['$names', '$$name']}]}, as: 'deliveryZipCodeTimings' } }"})

//    {
//        $lookup:
//        {
//            from: "Families",
//                    let: { product_name: "$name" },
//            pipeline: [
//            { $match:
//            { $expr:
//            { $and:
//                       [
//                { $eq: [ "$name",  "$$product_name" ] }
//                       ]
//            }
//            }
//            },
//            { $project: { name: 0} }
//           ],
//            as: "Families"
//        }
//    }




//
//    @Aggregation(pipeline = {
//            //"{$match: { name: ?0 } }",
//            "{$lookup: { from: \"Families\",let: { name: '$names' } , localField: \"familiaProduto.id\",\n" +
//                    "        foreignField: \"id\"," +
//                    "as: \"Family\"}}",
//            "pipeline: [{$match: { \"$expr: { $and: [{ $eq: [ {Family:'Familia1'} ] }\"]\"}}"})

        }
