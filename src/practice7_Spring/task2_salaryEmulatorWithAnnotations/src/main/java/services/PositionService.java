package services;

import entities.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Scope("singleton")
public class PositionService {

    private Map<Long, Position> positionMap;
    private Long id = 0L;
    private Long maxId = Long.MAX_VALUE;
    private Long findId;

    @Autowired
    public PositionService() {
        positionMap = new HashMap<>();
    }

    public void setPositionMap(Map<Long, Position> positionMap) {
        positionMap = positionMap;
    }

    public void setPositionMap() {
        positionMap = new HashMap<Long, Position>();
    }

    /**
     * Adds a new {@code Position} to the {@code positionMap}.
     *
     * @param position a new position.
     */
    public void addPosition(Position position) {
        if (!positionMap.containsValue(position) && position != null) {
            Long newId = ++id;
            if (newId > maxId || newId <= 0) {
                throw new IllegalArgumentException("The id value is incorrect.");
            }
            positionMap.put(newId, position);
        } else if (position == null) {
            throw new NullPointerException();
        }
    }

    /**
     * Removes a position from the {@code positionMap}.
     *
     * @param position a name position.
     */
    public void deletePosition(Position position) {
        if (position == null) throw new NullPointerException();
        positionMap.forEach((k, v) -> {
            if (v.equals(position)) findId = k;
        });
        positionMap.remove(findId);
        findId = null;
    }

    /**
     * Updates the position value
     *
     * @param id       key of position to update.
     * @param position is a new position.
     */
    public void updatePosition(Long id, Position position) {
        if (id == null || position == null) throw new NullPointerException();
        if (id > maxId || id <= 0) throw new IllegalArgumentException("The id value is incorrect.");
        if (!positionMap.containsKey(id)) throw new IllegalArgumentException("The map isn't contains key.");
        positionMap.computeIfPresent(id, (k, v) -> v = position);
    }

    /**
     * Finds all available positions.
     *
     * @return {@code positionMap}.
     */
    public Map<Long, Position> findAll() {
        return positionMap;
    }

    @Override
    public String toString() {
        return "PositionService{" +
                "positionMap=" + positionMap +
                ", id=" + id +
                '}';
    }
}
