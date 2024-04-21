package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.example.pojo.Goods;
import java.util.List;


@Mapper
public interface GoodsMapper {

    @Insert("insert into rizao.goods(name, price, detail, producer, classification) values (#{name}, #{price}, #{detail}, #{producer}, #{classification});")
    void add(Goods goods);

    List<Goods> selectByAny(Goods goods);

    @Delete("delete from rizao.goods where id = #{id} ")
    void deleteById(Integer id);

    @Update("UPDATE rizao.goods SET name = #{name}, price = #{price}, detail = #{detail}, producer = #{producer}, classification = #{classification} WHERE id = #{id}")
    void update(Goods goods);
}
