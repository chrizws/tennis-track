package com.xyz.tennistrack.other;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyz.tennistrack.dto.retailerDto.HolabirdDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MiscTests {

    @Test
    public void testTwoUrlStrings() throws JsonProcessingException {

        String json = "{\n" +
                "\t\"totalItems\": 183,\n" +
                "\t\"startIndex\": 0,\n" +
                "\t\"itemsPerPage\": 250,\n" +
                "\t\"currentItemCount\": 183,\n" +
                "\t\"items\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"product_id\": \"6187793875134\",\n" +
                "\t\t\t\"title\": \"HEAD Graphene XT Speed S\",\n" +
                "\t\t\t\"description\": \"\",\n" +
                "\t\t\t\"link\": \"\\/products\\/head-graphene-xt-speed-s\",\n" +
                "\t\t\t\"price\": \"99.0000\",\n" +
                "\t\t\t\"list_price\": \"210.0000\",\n" +
                "\t\t\t\"quantity\": \"1\",\n" +
                "\t\t\t\"product_code\": \"102791   1L\",\n" +
                "\t\t\t\"image_link\": \"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/2006\\/8755\\/products\\/102791_1_large.jpg?v=1611353102\",\n" +
                "\t\t\t\"vendor\": \"HEAD\",\n" +
                "\t\t\t\"discount\": \"53\",\n" +
                "\t\t\t\"add_to_cart_id\": \"37940761624766\",\n" +
                "\t\t\t\"total_reviews\": \"0\",\n" +
                "\t\t\t\"reviews_average_score\": \"0\",\n" +
                "\t\t\t\"shopify_variants\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"variant_id\": \"37940761624766\",\n" +
                "\t\t\t\t\t\"sku\": \"102791   1L\",\n" +
                "\t\t\t\t\t\"barcode\": \"726423967965\",\n" +
                "\t\t\t\t\t\"price\": \"99.0000\",\n" +
                "\t\t\t\t\t\"list_price\": \"210.0000\",\n" +
                "\t\t\t\t\t\"taxable\": \"1\",\n" +
                "\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\"Size\": \"1L - 4 1\\/8\\\"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"available\": \"1\",\n" +
                "\t\t\t\t\t\"search_variant_metafields_data\": [],\n" +
                "\t\t\t\t\t\"filter_variant_metafields_data\": [],\n" +
                "\t\t\t\t\t\"image_link\": \"\",\n" +
                "\t\t\t\t\t\"image_alt\": \"\",\n" +
                "\t\t\t\t\t\"quantity_at_location_42708746\": \"2\",\n" +
                "\t\t\t\t\t\"quantity_total\": \"2\",\n" +
                "\t\t\t\t\t\"link\": \"\\/products\\/head-graphene-xt-speed-s?variant=37940761624766\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"variant_id\": \"37940761690302\",\n" +
                "\t\t\t\t\t\"sku\": \"102791   2L\",\n" +
                "\t\t\t\t\t\"barcode\": \"726423967972\",\n" +
                "\t\t\t\t\t\"price\": \"99.0000\",\n" +
                "\t\t\t\t\t\"list_price\": \"210.0000\",\n" +
                "\t\t\t\t\t\"taxable\": \"1\",\n" +
                "\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\"Size\": \"2L - 4 1\\/4\\\"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"available\": \"0\",\n" +
                "\t\t\t\t\t\"search_variant_metafields_data\": [],\n" +
                "\t\t\t\t\t\"filter_variant_metafields_data\": [],\n" +
                "\t\t\t\t\t\"image_link\": \"\",\n" +
                "\t\t\t\t\t\"image_alt\": \"\",\n" +
                "\t\t\t\t\t\"quantity_total\": \"\",\n" +
                "\t\t\t\t\t\"link\": \"\\/products\\/head-graphene-xt-speed-s?variant=37940761690302\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"variant_id\": \"37940761788606\",\n" +
                "\t\t\t\t\t\"sku\": \"102791   3L\",\n" +
                "\t\t\t\t\t\"barcode\": \"726423967989\",\n" +
                "\t\t\t\t\t\"price\": \"99.0000\",\n" +
                "\t\t\t\t\t\"list_price\": \"210.0000\",\n" +
                "\t\t\t\t\t\"taxable\": \"1\",\n" +
                "\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\"Size\": \"3L - 4 3\\/8\\\"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"available\": \"1\",\n" +
                "\t\t\t\t\t\"search_variant_metafields_data\": [],\n" +
                "\t\t\t\t\t\"filter_variant_metafields_data\": [],\n" +
                "\t\t\t\t\t\"image_link\": \"\",\n" +
                "\t\t\t\t\t\"image_alt\": \"\",\n" +
                "\t\t\t\t\t\"quantity_at_location_42708746\": \"2\",\n" +
                "\t\t\t\t\t\"quantity_total\": \"2\",\n" +
                "\t\t\t\t\t\"link\": \"\\/products\\/head-graphene-xt-speed-s?variant=37940761788606\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t],\n" +
                "\t\t\t\"shopify_images\": [\n" +
                "\t\t\t\t\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/2006\\/8755\\/products\\/102791_1_large.jpg?v=1611353102\",\n" +
                "\t\t\t\t\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/2006\\/8755\\/products\\/102791_2_large.jpg?v=1611589173\",\n" +
                "\t\t\t\t\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/2006\\/8755\\/products\\/102791_3_large.jpg?v=1611589173\",\n" +
                "\t\t\t\t\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/2006\\/8755\\/products\\/102791_4_large.jpg?v=1611589173\"\n" +
                "\t\t\t],\n" +
                "\t\t\t\"shopify_images_alt\": [\n" +
                "\t\t\t\t\"\",\n" +
                "\t\t\t\t\"\",\n" +
                "\t\t\t\t\"\",\n" +
                "\t\t\t\t\"\"\n" +
                "\t\t\t],\n" +
                "\t\t\t\"tags\": \"ALLDEALS[:ATTR:]Balance_Head Light[:ATTR:]Brand_HEAD[:ATTR:]COLLECTION-Activity-Tennis[:ATTR:]COLLECTION-Type-Tennis Racquets[:ATTR:]Gender_Unisex[:ATTR:]Grip Size_1L - 4 1\\/8\\\"[:ATTR:]Grip Size_3L - 4 3\\/8\\\"[:ATTR:]Head Size_Mid+ (95-105 sq. in.)[:ATTR:]Length_Standard - 27 in.[:ATTR:]OnMap[:ATTR:]Type_Tennis Racquets[:ATTR:]Weight (unstrung)_Lightweight (9.6-11 oz.)\",\n" +
                "\t\t\t\"quantity_total\": \"4\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"product_id\": \"7544177426622\",\n" +
                "\t\t\t\"title\": \"Wilson Pro Staff 97 v14\",\n" +
                "\t\t\t\"description\": \"\",\n" +
                "\t\t\t\"link\": \"\\/products\\/wilson-pro-staff-97-v13\",\n" +
                "\t\t\t\"price\": \"209.2500\",\n" +
                "\t\t\t\"list_price\": \"279.0000\",\n" +
                "\t\t\t\"quantity\": \"1\",\n" +
                "\t\t\t\"product_code\": \"102977   1L\",\n" +
                "\t\t\t\"image_link\": \"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/2006\\/8755\\/products\\/102977_1_large.jpg?v=1675458369\",\n" +
                "\t\t\t\"vendor\": \"Wilson\",\n" +
                "\t\t\t\"discount\": \"25\",\n" +
                "\t\t\t\"add_to_cart_id\": \"42518449586366\",\n" +
                "\t\t\t\"total_reviews\": \"0\",\n" +
                "\t\t\t\"reviews_average_score\": \"0\",\n" +
                "\t\t\t\"shopify_variants\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"variant_id\": \"42518449586366\",\n" +
                "\t\t\t\t\t\"sku\": \"102977   1L\",\n" +
                "\t\t\t\t\t\"barcode\": \"097512683920\",\n" +
                "\t\t\t\t\t\"price\": \"209.2500\",\n" +
                "\t\t\t\t\t\"list_price\": \"279.0000\",\n" +
                "\t\t\t\t\t\"taxable\": \"1\",\n" +
                "\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\"Size\": \"1L - 4 1\\/8\\\"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"available\": \"1\",\n" +
                "\t\t\t\t\t\"search_variant_metafields_data\": [],\n" +
                "\t\t\t\t\t\"filter_variant_metafields_data\": [],\n" +
                "\t\t\t\t\t\"image_link\": \"\",\n" +
                "\t\t\t\t\t\"image_alt\": \"\",\n" +
                "\t\t\t\t\t\"quantity_at_location_42708746\": \"1\",\n" +
                "\t\t\t\t\t\"quantity_total\": \"1\",\n" +
                "\t\t\t\t\t\"link\": \"\\/products\\/wilson-pro-staff-97-v13?variant=42518449586366\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"variant_id\": \"42518449619134\",\n" +
                "\t\t\t\t\t\"sku\": \"102977   2L\",\n" +
                "\t\t\t\t\t\"barcode\": \"097512683944\",\n" +
                "\t\t\t\t\t\"price\": \"209.2500\",\n" +
                "\t\t\t\t\t\"list_price\": \"279.0000\",\n" +
                "\t\t\t\t\t\"taxable\": \"1\",\n" +
                "\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\"Size\": \"2L - 4 1\\/4\\\"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"available\": \"1\",\n" +
                "\t\t\t\t\t\"search_variant_metafields_data\": [],\n" +
                "\t\t\t\t\t\"filter_variant_metafields_data\": [],\n" +
                "\t\t\t\t\t\"image_link\": \"\",\n" +
                "\t\t\t\t\t\"image_alt\": \"\",\n" +
                "\t\t\t\t\t\"quantity_at_location_42708746\": \"4\",\n" +
                "\t\t\t\t\t\"quantity_total\": \"4\",\n" +
                "\t\t\t\t\t\"link\": \"\\/products\\/wilson-pro-staff-97-v13?variant=42518449619134\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"variant_id\": \"42518449651902\",\n" +
                "\t\t\t\t\t\"sku\": \"102977   3L\",\n" +
                "\t\t\t\t\t\"barcode\": \"097512683937\",\n" +
                "\t\t\t\t\t\"price\": \"209.2500\",\n" +
                "\t\t\t\t\t\"list_price\": \"279.0000\",\n" +
                "\t\t\t\t\t\"taxable\": \"1\",\n" +
                "\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\"Size\": \"3L - 4 3\\/8\\\"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"available\": \"1\",\n" +
                "\t\t\t\t\t\"search_variant_metafields_data\": [],\n" +
                "\t\t\t\t\t\"filter_variant_metafields_data\": [],\n" +
                "\t\t\t\t\t\"image_link\": \"\",\n" +
                "\t\t\t\t\t\"image_alt\": \"\",\n" +
                "\t\t\t\t\t\"quantity_at_location_42708746\": \"4\",\n" +
                "\t\t\t\t\t\"quantity_total\": \"4\",\n" +
                "\t\t\t\t\t\"link\": \"\\/products\\/wilson-pro-staff-97-v13?variant=42518449651902\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"variant_id\": \"42518449684670\",\n" +
                "\t\t\t\t\t\"sku\": \"102977   4L\",\n" +
                "\t\t\t\t\t\"barcode\": \"097512683951\",\n" +
                "\t\t\t\t\t\"price\": \"209.2500\",\n" +
                "\t\t\t\t\t\"list_price\": \"279.0000\",\n" +
                "\t\t\t\t\t\"taxable\": \"1\",\n" +
                "\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\"Size\": \"4L - 4 1\\/2\\\"\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"available\": \"1\",\n" +
                "\t\t\t\t\t\"search_variant_metafields_data\": [],\n" +
                "\t\t\t\t\t\"filter_variant_metafields_data\": [],\n" +
                "\t\t\t\t\t\"image_link\": \"\",\n" +
                "\t\t\t\t\t\"image_alt\": \"\",\n" +
                "\t\t\t\t\t\"quantity_at_location_42708746\": \"4\",\n" +
                "\t\t\t\t\t\"quantity_total\": \"4\",\n" +
                "\t\t\t\t\t\"link\": \"\\/products\\/wilson-pro-staff-97-v13?variant=42518449684670\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t],\n" +
                "\t\t\t\"shopify_images\": [\n" +
                "\t\t\t\t\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/2006\\/8755\\/products\\/102977_1_large.jpg?v=1675458369\",\n" +
                "\t\t\t\t\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/2006\\/8755\\/products\\/102977_2_large.jpg?v=1675458369\",\n" +
                "\t\t\t\t\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/2006\\/8755\\/products\\/102977_3_large.jpg?v=1675458370\",\n" +
                "\t\t\t\t\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/2006\\/8755\\/products\\/102977_4_large.jpg?v=1675458371\"\n" +
                "\t\t\t],\n" +
                "\t\t\t\"shopify_images_alt\": [\n" +
                "\t\t\t\t\"\",\n" +
                "\t\t\t\t\"\",\n" +
                "\t\t\t\t\"\",\n" +
                "\t\t\t\t\"\"\n" +
                "\t\t\t],\n" +
                "\t\t\t\"tags\": \"ALLDEALS[:ATTR:]Balance_Head Light[:ATTR:]bis-hidden[:ATTR:]black_crow_do_not_cross_sell[:ATTR:]black_crow_do_not_replenish[:ATTR:]black_crow_do_not_subscribe[:ATTR:]Brand_Wilson[:ATTR:]COLLECTION-Activity-Tennis[:ATTR:]COLLECTION-Type-Tennis Racquets[:ATTR:]EXPEDITED-SHIPPING[:ATTR:]FREIGHTCODE-X[:ATTR:]Gender_Unisex[:ATTR:]Grip Size_1L - 4 1\\/8\\\"[:ATTR:]Grip Size_2L - 4 1\\/4\\\"[:ATTR:]Grip Size_3L - 4 3\\/8\\\"[:ATTR:]Grip Size_4L - 4 1\\/2\\\"[:ATTR:]Head Size_Mid+ (95-105 sq. in.)[:ATTR:]Length_Standard - 27 in.[:ATTR:]OnMap[:ATTR:]Type_Tennis Racquets[:ATTR:]Weight (unstrung)_Heavy (11.1+ oz.)\",\n" +
                "\t\t\t\"quantity_total\": \"13\"\n" +
                "\t\t}\n" +
                "]}";


        HolabirdDTO dto = new ObjectMapper()
                .readerFor(HolabirdDTO.class)
                .readValue(json);

        System.out.println(dto);

    }
}
