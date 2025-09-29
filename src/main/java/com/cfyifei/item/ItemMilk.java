package com.cfyifei.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMilk extends ItemFood {
    public boolean e;
    private float saturationAmount;
    
    public ItemMilk(int amount, float saturation, boolean isWolfFood, String name) {
        super((int) saturation, saturation / 3F, isWolfFood);
        this.setUnlocalizedName(name);
        this.saturationAmount = saturation;
    }

    public ItemMilk(int amount, float saturation, boolean isWolfFood, String name, boolean is) {
        super((int) saturation, saturation / 3F, isWolfFood);
        this.setUnlocalizedName(name);
        this.saturationAmount = saturation;
        e = is;
    }

    public boolean hasEffect(ItemStack par1ItemStack) {
        return e;
    }

    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.drink;
    }

    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        --par1ItemStack.stackSize;
        par3EntityPlayer.getFoodStats().addStats(this.func_150905_g(par1ItemStack), this.saturationAmount);
        par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
        this.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
        par3EntityPlayer.curePotionEffects(new ItemStack(Items.milk_bucket));
        return par1ItemStack;
    }
}


