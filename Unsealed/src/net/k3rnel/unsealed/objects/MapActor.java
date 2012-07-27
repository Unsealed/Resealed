package net.k3rnel.unsealed.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class MapActor extends Image {
	
	public static final int groupMap = 1;
	public static final int groupPlayer = 2;
	public static final int groupNPC = 3;
	
	private Map map;
	private int tileX;
	private int tileY;
	private int group;
	private int collisionGroup;
	private boolean mapCollidable;
	
	private TextureAtlas atlas;
	
	public MapActor() {
		this.tileX = -1;
		this.tileY = -1;
		this.collisionGroup = 0;
		this.group = 0;
		this.mapCollidable = true;
	}

	public int getCollisionGroup() {
		return collisionGroup;
	}

	public void setCollisionGroup(int collision) {
		this.collisionGroup = collision;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public int getTileX() {
		return tileX;
	}
	
	public int getTileY() {
		return tileY;
	}
	
	public void setTileX(int tileX) {
		this.tileX = tileX;
	}
	
	public void setTileY(int tileY) {
		this.tileY = tileY;
	}
	
	public void setTilePos(int tileX, int tileY) {
		this.tileX = tileX;
		this.tileY = tileY;
	}
	
	public boolean move(int tileX, int tileY) {
		if(map == null)
			return false;
		
		return map.moveActor(this, tileX, tileY);
	}
	
	public boolean warp(int tileX, int tileY) {
		if(map == null)
			return false;
		
		return map.warpActor(this, tileX, tileY);
	}
	
	public void moved(int tileX, int tileY) {
		
	}
	
	public void moveStarted() {
		
	}
	
	public void moveStopped() {
		
	}

	public boolean getMapCollidable() {
		return mapCollidable;
	}

	public void setMapCollidable(boolean mapCollidable) {
		this.mapCollidable = mapCollidable;
	}
	 public TextureAtlas getAtlas() {
	        if( atlas == null ) {
	            atlas = new TextureAtlas( Gdx.files.internal( "image-atlases/pages-info.atlas" ) );
	        }
	        return atlas;
	    }
}
