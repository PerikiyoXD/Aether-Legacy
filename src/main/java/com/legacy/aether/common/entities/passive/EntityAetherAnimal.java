package com.legacy.aether.common.entities.passive;

import java.util.Random;

import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.legacy.aether.common.blocks.BlocksAether;

public abstract class EntityAetherAnimal extends EntityAnimal
{

	Random random = new Random();

	public EntityAetherAnimal(World worldIn) 
	{
		super(worldIn);
		this.spawnableBlock = BlocksAether.aether_grass;
	}

	@Override
    public float getBlockPathWeight(BlockPos pos)
    {
    	return this.world.getBlockState(pos.down()).getBlock() == this.spawnableBlock ? 10.0F : this.world.getLightBrightness(pos) - 0.5F;
    }

	@Override
    public boolean isBreedingItem(ItemStack stack)
    {
		return false;
    }

}