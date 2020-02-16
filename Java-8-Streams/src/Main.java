
public class Main {

    public static void main(String[] args) {

        System.out.println("Streams");

        ForEachExamples.foreachAndList();
        ForEachExamples.foreachAndMap();

        FilterExamples.filterAndCollect();
        FilterExamples.filterAndFindAnyAndOrElse();
        FilterExamples.filterAndMap();

        MapExamples.listOfStringToUpperCase();
        MapExamples.convertListOfObjectToListOfString();
        MapExamples.convertObjectToAnotherObject();

        CollectorsExample.groupByListAndDisplayTheTotalCountOfIt();
        CollectorsExample.groupByListOfUserDefinedObjects();

        FilterExamples.filterNullValueFromStream();

        StreamConverterExamples.convertStreamToList();
        StreamConverterExamples.convertArrayToStream();
        StreamConverterExamples.convertPrimitiveArraysToStream();

        //OperatedStreamHandlingExample.closedStreamProblem();
        OperatedStreamHandlingExample.workingWithClosedStream();


        MapSortingExamples.sortByKeys();
        MapSortingExamples.sortMapOfObjectKeyAndObjectValue();

    }


}
