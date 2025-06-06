package com.recommender.system;

import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

import java.io.File;
import java.util.List;

public class ItemRecommend {

    public static void main(String[] args) {
        try {

            // Load data from CSV
            DataModel dataModel = new FileDataModel(new File("F:\\Internship2025java\\workspace\\ItemRecommend" +
                                                                            "\\src\\main\\resources\\movies.csv"));
            // Calculate similarity between users
            TanimotoCoefficientSimilarity tanimotoCoefficientSimilarity = new TanimotoCoefficientSimilarity(dataModel);

            // Define neighborhood size (e.g., 2 nearest users)
            ItemSimilarity itemSimilarity = new LogLikelihoodSimilarity(dataModel);

            // Print the recommendations
            GenericItemBasedRecommender genericItemBasedRecommender = new GenericItemBasedRecommender
                                                                            (dataModel, itemSimilarity);

            int x = 1;

            for (LongPrimitiveIterator items = dataModel.getItemIDs(); items.hasNext(); ) {
                long itemId = items.nextLong();

                //Generate Recommendations
                List<RecommendedItem> recommendedItems = genericItemBasedRecommender.mostSimilarItems(itemId, 5);

                for (RecommendedItem recommendedItem : recommendedItems) {
                    System.out.println(itemId + "," + recommendedItem.getItemID() + "," + recommendedItem.getValue());
                }
                x++;
                if (x > 10)
                    break;
            }

        } catch (Exception e) {
            System.out.println("There was an error!!");
            e.printStackTrace();
        }
    }
}
