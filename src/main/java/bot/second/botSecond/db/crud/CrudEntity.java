package bot.second.botSecond.db.crud;

import bot.second.botSecond.Entity.Master;
import bot.second.botSecond.Entity.MyEntity;

import java.util.List;

public interface CrudEntity {

    void createEntity(MyEntity entity);
    List readEntity(MyEntity entity);
    void updateEntity(MyEntity entity);
    void deleteEntity(Master entity);
}
