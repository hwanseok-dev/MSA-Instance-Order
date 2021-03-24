package me.hwanseok.simplemsaorder.repository;

import me.hwanseok.simplemsaorder.config.JpaConfig;
import me.hwanseok.simplemsaorder.model.entity.LineItem;
import me.hwanseok.simplemsaorder.model.entity.OrderGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@DataJpaTest                                                                    // JPA 테스트 관련 컴포넌트만 Import
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // 실제 db 사용
@DisplayName("ItemRepositoryTest 테스트")
@Import({JpaConfig.class})
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class OrderGroupRepositoryTest {

    @Autowired
    private OrderGroupRepository orderGroupRepository;

//    @Test
//    @DisplayName("Order Create Test")
//    public void create() {
//        System.out.println("hello");
////        Long productId = 481L;
////        for(int i=0; i<10; i++){
////            OrderGroup orderGroup = OrderGroup.builder()
////                    .description("orderDescription"+i)
////                    .lineItems(new ArrayList<>())
////                    .build();
////            orderGroup.setLineItems(LineItem.builder().description("LineItemDescription"+i).productId(productId).build());
////            orderGroupRepository.save(orderGroup);
////        }
//    }
//
//    @Test
//    public void read() {
//        Long id = 477L;
//        Optional<OrderGroup> product = orderGroupRepository.findById(id);
//        System.out.println(product);
//        Assertions.assertTrue(product.isPresent());
//    }
//
//    @Test
//    public void update() {
//        Long id = 477L;
//        Optional<OrderGroup> product = orderGroupRepository.findById(id);
//        System.out.println(product);
//        product.ifPresent(selectedProduct -> {
//            selectedProduct.setDescription("changedDescription");
//            orderGroupRepository.save(selectedProduct);
//        });
//    }
//
//    @Test
//    public void delete() {
//        Long id = 477L;
//        Optional<OrderGroup> product = orderGroupRepository.findById(id);
//        Assertions.assertTrue(product.isPresent());    // false
//        product.ifPresent(selectUser -> {
//            orderGroupRepository.delete(selectUser);
//        });
//        Optional<OrderGroup> deleteProduct = orderGroupRepository.findById(3L);
//        Assertions.assertFalse(deleteProduct.isPresent()); // false
//    }

}
