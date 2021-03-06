package game.map.card.group;

import game.data.card.group.GroupDefense2;
import game.map.IMap;
import game.map.IParse;

import java.util.HashMap;
import java.util.Map;

public class MapGroupDefense2 implements IMap, IParse {

	private static MapGroupDefense2 instance;

	private Map<Integer, Map<Integer, GroupDefense2>> map;

	private MapGroupDefense2() {
		map = new HashMap<Integer, Map<Integer, GroupDefense2>>();
	}

	public static MapGroupDefense2 getInstance() {
		if (null == instance)
			instance = new MapGroupDefense2();
		return instance;
	}

	@Override
	public Map<?, ?> getMap() {
		return map;
	}

	@Override
	public void add(Object obj) {
		if (obj instanceof GroupDefense2) {
			GroupDefense2 data = (GroupDefense2) obj;
			int start = data.getStar();
			int level = data.getLevel();
			if (map.containsKey(start)) {
				map.get(start).put(level, data);
			} else {
				Map<Integer, GroupDefense2> info = new HashMap<Integer, GroupDefense2>();
				info.put(level, data);
				map.put(start, info);
			}
		}
	}

	public Map<Integer, GroupDefense2> getData(int start) {
		return map.get(start);
	}

	@Override
	public String getBeanName() {
		return "value.group.defense2.so";
	}

	@Override
	public String getIDataName() {
		return GroupDefense2.class.getName();
	}

	@Override
	public IMap getRoot() {
		return this;
	}
}
