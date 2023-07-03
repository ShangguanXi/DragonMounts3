// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

package net.dragonmounts.client.models;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class DragonDefaultModel<T extends Entity> extends EntityModel<T> {
    private final ModelPart body;
    private final ModelPart neck;
    private final ModelPart neckpart1;
    private final ModelPart neckpart2;
    private final ModelPart neckpart3;
    private final ModelPart neckpart4;
    private final ModelPart neckpart5;
    private final ModelPart head;
    private final ModelPart Horn0;
    private final ModelPart Horn1;
    private final ModelPart jaw;
    private final ModelPart backhorns;
    private final ModelPart front_back_horns;
    private final ModelPart tail;
    private final ModelPart tailpart1;
    private final ModelPart tailpart2;
    private final ModelPart tailpart3;
    private final ModelPart tailpart4;
    private final ModelPart tailpart5;
    private final ModelPart tailpart6;
    private final ModelPart tailpart7;
    private final ModelPart tailpart8;
    private final ModelPart tailpart9;
    private final ModelPart tailpart10;
    private final ModelPart tailpart11;
    private final ModelPart tailpart12;
    private final ModelPart tailhorns7;
    private final ModelPart tailhorns8;
    private final ModelPart tailhorns9;
    private final ModelPart tailhorns10;
    private final ModelPart tailhorns11;
    private final ModelPart tailhorns12;
    private final ModelPart tailhorns6;
    private final ModelPart tailhorns5;
    private final ModelPart tailhorns4;
    private final ModelPart tailhorns3;
    private final ModelPart tailhorns2;
    private final ModelPart tailhorns1;
    private final ModelPart leftfrontleg;
    private final ModelPart cube_r1;
    private final ModelPart leftfrontlegcombin;
    private final ModelPart leftfrontfoot;
    private final ModelPart cube_r2;
    private final ModelPart leftfrontfootD;
    private final ModelPart rightfrontleg;
    private final ModelPart cube_r3;
    private final ModelPart rightfrontlegcombin;
    private final ModelPart rightfrontfoot;
    private final ModelPart cube_r4;
    private final ModelPart rightfrontfootD;
    private final ModelPart leftrearleg;
    private final ModelPart leftrearlegcombin;
    private final ModelPart cube_r5;
    private final ModelPart leftrearfoot;
    private final ModelPart leftrearfootD;
    private final ModelPart rightrearleg;
    private final ModelPart rightrearlegcombin;
    private final ModelPart cube_r6;
    private final ModelPart rightrearfoot;
    private final ModelPart rightrearfootD;
    private final ModelPart rightwing;
    private final ModelPart rightwingpart1;
    private final ModelPart rightwingp1;
    private final ModelPart rightwingpart2;
    private final ModelPart rightwingpart3;
    private final ModelPart rightwingp2;
    private final ModelPart rightwingpart4;
    private final ModelPart rightwingp3;
    private final ModelPart rightwingpart5;
    private final ModelPart rightwingp4;
    private final ModelPart rightwingpart6;
    private final ModelPart rightwingp5;
    private final ModelPart leftwing;
    private final ModelPart leftwingpart1;
    private final ModelPart leftwingp1;
    private final ModelPart leftwingpart2;
    private final ModelPart leftwingpart3;
    private final ModelPart leftwingp2;
    private final ModelPart leftwingpart4;
    private final ModelPart leftwingp3;
    private final ModelPart leftwingpart5;
    private final ModelPart leftwingp4;
    private final ModelPart leftwingpart6;
    private final ModelPart leftwingp5;

    public DragonDefaultModel() {textureWidth = 256;
        textureHeight = 256;
        body = new ModelPart(this);
        body.setPivot(0.0F, -7.0F, -2.0F);
        body.setTextureOffset(0, 0).addCuboid(-12.0F, -12.0F, -32.0F, 24.0F, 24.0F, 64.0F, 0.0F, false);

        neck = new ModelPart(this);
        neck.setPivot(0.0F, 0.0F, -32.0F);
        body.addChild(neck);


        neckpart1 = new ModelPart(this);
        neckpart1.setPivot(0.0F, 0.0F, -5.0F);
        neck.addChild(neckpart1);
        neckpart1.setTextureOffset(112, 88).addCuboid(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

        neckpart2 = new ModelPart(this);
        neckpart2.setPivot(0.0F, 0.0F, -10.0F);
        neckpart1.addChild(neckpart2);
        neckpart2.setTextureOffset(112, 88).addCuboid(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
        neckpart2.setTextureOffset(0, 0).addCuboid(-1.0F, -9.0F, -3.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);

        neckpart3 = new ModelPart(this);
        neckpart3.setPivot(0.0F, 0.0F, -10.0F);
        neckpart2.addChild(neckpart3);
        neckpart3.setTextureOffset(112, 88).addCuboid(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

        neckpart4 = new ModelPart(this);
        neckpart4.setPivot(0.0F, 0.0F, -10.0F);
        neckpart3.addChild(neckpart4);
        neckpart4.setTextureOffset(112, 88).addCuboid(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
        neckpart4.setTextureOffset(0, 0).addCuboid(-1.0F, -9.0F, -3.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);

        neckpart5 = new ModelPart(this);
        neckpart5.setPivot(0.0F, 0.0F, -10.0F);
        neckpart4.addChild(neckpart5);
        neckpart5.setTextureOffset(112, 88).addCuboid(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

        head = new ModelPart(this);
        head.setPivot(0.0F, -1.0F, -5.0F);
        neckpart5.addChild(head);
        head.setTextureOffset(0, 0).addCuboid(-8.0F, -8.0F, -16.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        head.setTextureOffset(56, 88).addCuboid(-6.0F, -1.0F, -32.0F, 12.0F, 5.0F, 16.0F, 0.0F, false);
        head.setTextureOffset(48, 0).addCuboid(-5.0F, -3.0F, -30.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
        head.setTextureOffset(48, 0).addCuboid(3.0F, -3.0F, -30.0F, 2.0F, 2.0F, 4.0F, 0.0F, true);

        Horn0 = new ModelPart(this);
        Horn0.setPivot(4.0F, -6.5F, -8.0F);
        head.addChild(Horn0);
        setRotationAngle(Horn0, 0.4363F, 0.4363F, 0.0F);
        Horn0.setTextureOffset(28, 32).addCuboid(-1.2F, -2.0F, 0.0F, 3.0F, 3.0F, 12.0F, 0.0F, false);

        Horn1 = new ModelPart(this);
        Horn1.setPivot(-4.0F, -6.5F, -8.0F);
        head.addChild(Horn1);
        setRotationAngle(Horn1, 0.4363F, -0.4363F, 0.0F);
        Horn1.setTextureOffset(28, 32).addCuboid(-1.8F, -2.0F, 0.0F, 3.0F, 3.0F, 12.0F, 0.0F, true);

        jaw = new ModelPart(this);
        jaw.setPivot(0.0F, 6.0F, -17.0F);
        head.addChild(jaw);
        jaw.setTextureOffset(0, 88).addCuboid(-6.0F, -2.0F, -15.0F, 12.0F, 4.0F, 16.0F, 0.0F, false);

        backhorns = new ModelPart(this);
        backhorns.setPivot(0.0F, -15.0F, 0.0F);
        body.addChild(backhorns);
        backhorns.setTextureOffset(0, 32).addCuboid(-1.0F, -3.0F, -6.0F, 2.0F, 6.0F, 12.0F, 0.0F, false);
        backhorns.setTextureOffset(0, 32).addCuboid(-1.0F, -3.0F, 14.0F, 2.0F, 6.0F, 12.0F, 0.0F, false);

        front_back_horns = new ModelPart(this);
        front_back_horns.setPivot(0.0F, 23.0F, -90.0F);
        backhorns.addChild(front_back_horns);
        front_back_horns.setTextureOffset(0, 32).addCuboid(-1.0F, -26.0F, 64.0F, 2.0F, 6.0F, 12.0F, 0.0F, false);

        tail = new ModelPart(this);
        tail.setPivot(0.0F, -3.0F, 32.0F);
        body.addChild(tail);


        tailpart1 = new ModelPart(this);
        tailpart1.setPivot(0.0F, 0.0F, 0.0F);
        tail.addChild(tailpart1);
        tailpart1.setTextureOffset(152, 88).addCuboid(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

        tailpart2 = new ModelPart(this);
        tailpart2.setPivot(0.0F, 0.0F, 10.0F);
        tailpart1.addChild(tailpart2);
        tailpart2.setTextureOffset(152, 88).addCuboid(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

        tailpart3 = new ModelPart(this);
        tailpart3.setPivot(0.0F, 0.0F, 10.0F);
        tailpart2.addChild(tailpart3);
        tailpart3.setTextureOffset(152, 88).addCuboid(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

        tailpart4 = new ModelPart(this);
        tailpart4.setPivot(0.0F, 0.0F, 10.0F);
        tailpart3.addChild(tailpart4);
        tailpart4.setTextureOffset(152, 88).addCuboid(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

        tailpart5 = new ModelPart(this);
        tailpart5.setPivot(0.0F, 0.0F, 10.0F);
        tailpart4.addChild(tailpart5);
        tailpart5.setTextureOffset(152, 88).addCuboid(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

        tailpart6 = new ModelPart(this);
        tailpart6.setPivot(0.0F, 0.0F, 10.0F);
        tailpart5.addChild(tailpart6);
        tailpart6.setTextureOffset(152, 88).addCuboid(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

        tailpart7 = new ModelPart(this);
        tailpart7.setPivot(0.0F, 0.0F, 10.0F);
        tailpart6.addChild(tailpart7);
        tailpart7.setTextureOffset(152, 88).addCuboid(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

        tailpart8 = new ModelPart(this);
        tailpart8.setPivot(0.0F, 0.0F, 10.0F);
        tailpart7.addChild(tailpart8);
        tailpart8.setTextureOffset(152, 88).addCuboid(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

        tailpart9 = new ModelPart(this);
        tailpart9.setPivot(0.0F, 0.0F, 10.0F);
        tailpart8.addChild(tailpart9);
        tailpart9.setTextureOffset(152, 88).addCuboid(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

        tailpart10 = new ModelPart(this);
        tailpart10.setPivot(0.0F, 0.0F, 10.0F);
        tailpart9.addChild(tailpart10);
        tailpart10.setTextureOffset(152, 88).addCuboid(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

        tailpart11 = new ModelPart(this);
        tailpart11.setPivot(0.0F, 0.0F, 10.0F);
        tailpart10.addChild(tailpart11);
        tailpart11.setTextureOffset(152, 88).addCuboid(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

        tailpart12 = new ModelPart(this);
        tailpart12.setPivot(0.0F, 0.0F, 10.0F);
        tailpart11.addChild(tailpart12);
        tailpart12.setTextureOffset(152, 88).addCuboid(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

        tailhorns7 = new ModelPart(this);
        tailhorns7.setPivot(0.0F, 0.0F, 0.0F);
        tailpart12.addChild(tailhorns7);
        tailhorns7.setTextureOffset(0, 0).addCuboid(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);

        tailhorns8 = new ModelPart(this);
        tailhorns8.setPivot(0.0F, 0.0F, 0.0F);
        tailpart11.addChild(tailhorns8);
        tailhorns8.setTextureOffset(0, 0).addCuboid(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);

        tailhorns9 = new ModelPart(this);
        tailhorns9.setPivot(0.0F, 0.0F, 0.0F);
        tailpart10.addChild(tailhorns9);
        tailhorns9.setTextureOffset(0, 0).addCuboid(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);

        tailhorns10 = new ModelPart(this);
        tailhorns10.setPivot(0.0F, 0.0F, 0.0F);
        tailpart9.addChild(tailhorns10);
        tailhorns10.setTextureOffset(0, 0).addCuboid(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);

        tailhorns11 = new ModelPart(this);
        tailhorns11.setPivot(0.0F, 0.0F, 0.0F);
        tailpart8.addChild(tailhorns11);
        tailhorns11.setTextureOffset(0, 0).addCuboid(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);

        tailhorns12 = new ModelPart(this);
        tailhorns12.setPivot(0.0F, 0.0F, 0.0F);
        tailpart7.addChild(tailhorns12);
        tailhorns12.setTextureOffset(0, 0).addCuboid(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);

        tailhorns6 = new ModelPart(this);
        tailhorns6.setPivot(0.0F, 0.0F, 0.0F);
        tailpart6.addChild(tailhorns6);
        tailhorns6.setTextureOffset(0, 0).addCuboid(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);

        tailhorns5 = new ModelPart(this);
        tailhorns5.setPivot(0.0F, 0.0F, 0.0F);
        tailpart5.addChild(tailhorns5);
        tailhorns5.setTextureOffset(0, 0).addCuboid(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);

        tailhorns4 = new ModelPart(this);
        tailhorns4.setPivot(0.0F, 0.0F, 0.0F);
        tailpart4.addChild(tailhorns4);
        tailhorns4.setTextureOffset(0, 0).addCuboid(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);

        tailhorns3 = new ModelPart(this);
        tailhorns3.setPivot(0.0F, 0.0F, 0.0F);
        tailpart3.addChild(tailhorns3);
        tailhorns3.setTextureOffset(0, 0).addCuboid(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);

        tailhorns2 = new ModelPart(this);
        tailhorns2.setPivot(0.0F, 0.0F, 0.0F);
        tailpart2.addChild(tailhorns2);
        tailhorns2.setTextureOffset(0, 0).addCuboid(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);

        tailhorns1 = new ModelPart(this);
        tailhorns1.setPivot(0.0F, 0.0F, 0.0F);
        tailpart1.addChild(tailhorns1);
        tailhorns1.setTextureOffset(0, 0).addCuboid(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);

        leftfrontleg = new ModelPart(this);
        leftfrontleg.setPivot(12.5F, -2.0F, -24.5F);
        body.addChild(leftfrontleg);
        setRotationAngle(leftfrontleg, -0.4363F, 0.2618F, 0.0F);


        cube_r1 = new ModelPart(this);
        cube_r1.setPivot(0.0F, 0.0F, 0.0F);
        leftfrontleg.addChild(cube_r1);
        setRotationAngle(cube_r1, 1.2217F, 0.0F, 0.0F);
        cube_r1.setTextureOffset(112, 0).addCuboid(-6.5F, 0.0F, -4.5F, 9.0F, 20.0F, 9.0F, 0.0F, false);

        leftfrontlegcombin = new ModelPart(this);
        leftfrontlegcombin.setPivot(-2.0F, 5.0F, 19.5F);
        leftfrontleg.addChild(leftfrontlegcombin);
        setRotationAngle(leftfrontlegcombin, -0.3491F, 0.0F, 0.0F);
        leftfrontlegcombin.setTextureOffset(148, 0).addCuboid(-3.5F, 0.0F, -3.5F, 7.0F, 20.0F, 7.0F, 0.0F, false);

        leftfrontfoot = new ModelPart(this);
        leftfrontfoot.setPivot(-3.5F, 26.0F, 3.0F);
        leftfrontlegcombin.addChild(leftfrontfoot);
        setRotationAngle(leftfrontfoot, 1.5708F, 0.0F, 0.0F);


        cube_r2 = new ModelPart(this);
        cube_r2.setPivot(3.5F, -2.0F, 6.0F);
        leftfrontfoot.addChild(cube_r2);
        setRotationAngle(cube_r2, -0.1309F, 0.0F, 0.0F);
        cube_r2.setTextureOffset(210, 0).addCuboid(-4.5F, -3.0F, -7.0F, 9.0F, 4.0F, 8.0F, 0.0F, false);

        leftfrontfootD = new ModelPart(this);
        leftfrontfootD.setPivot(3.5F, -3.0F, 0.3F);
        leftfrontfoot.addChild(leftfrontfootD);
        setRotationAngle(leftfrontfootD, -0.7418F, 0.0F, 0.0F);
        leftfrontfootD.setTextureOffset(177, 0).addCuboid(-4.5F, -2.0F, -8.3F, 9.0F, 4.0F, 8.0F, 0.0F, false);

        rightfrontleg = new ModelPart(this);
        rightfrontleg.setPivot(-12.5F, -2.0F, -24.5F);
        body.addChild(rightfrontleg);
        setRotationAngle(rightfrontleg, -0.4363F, -0.2618F, 0.0F);


        cube_r3 = new ModelPart(this);
        cube_r3.setPivot(0.0F, 0.0F, 0.0F);
        rightfrontleg.addChild(cube_r3);
        setRotationAngle(cube_r3, 1.2217F, 0.0F, 0.0F);
        cube_r3.setTextureOffset(112, 0).addCuboid(-2.5F, 0.0F, -4.5F, 9.0F, 20.0F, 9.0F, 0.0F, true);

        rightfrontlegcombin = new ModelPart(this);
        rightfrontlegcombin.setPivot(2.0F, 5.0F, 19.5F);
        rightfrontleg.addChild(rightfrontlegcombin);
        setRotationAngle(rightfrontlegcombin, -0.3491F, 0.0F, 0.0F);
        rightfrontlegcombin.setTextureOffset(148, 0).addCuboid(-3.5F, 0.0F, -3.5F, 7.0F, 20.0F, 7.0F, 0.0F, true);

        rightfrontfoot = new ModelPart(this);
        rightfrontfoot.setPivot(3.5F, 26.0F, 3.0F);
        rightfrontlegcombin.addChild(rightfrontfoot);
        setRotationAngle(rightfrontfoot, 1.5708F, 0.0F, 0.0F);


        cube_r4 = new ModelPart(this);
        cube_r4.setPivot(-3.5F, -2.0F, 6.0F);
        rightfrontfoot.addChild(cube_r4);
        setRotationAngle(cube_r4, -0.1309F, 0.0F, 0.0F);
        cube_r4.setTextureOffset(210, 0).addCuboid(-4.5F, -3.0F, -7.0F, 9.0F, 4.0F, 8.0F, 0.0F, true);

        rightfrontfootD = new ModelPart(this);
        rightfrontfootD.setPivot(-3.5F, -3.0F, 0.3F);
        rightfrontfoot.addChild(rightfrontfootD);
        setRotationAngle(rightfrontfootD, -0.7418F, 0.0F, 0.0F);
        rightfrontfootD.setTextureOffset(177, 0).addCuboid(-4.5F, -2.0F, -8.3F, 9.0F, 4.0F, 8.0F, 0.0F, true);

        leftrearleg = new ModelPart(this);
        leftrearleg.setPivot(11.0F, -5.0F, 23.5F);
        body.addChild(leftrearleg);
        setRotationAngle(leftrearleg, -0.192F, -0.2618F, 0.0F);
        leftrearleg.setTextureOffset(112, 29).addCuboid(-5.0F, 0.0F, -5.0F, 10.0F, 23.0F, 10.0F, 0.0F, false);

        leftrearlegcombin = new ModelPart(this);
        leftrearlegcombin.setPivot(0.0F, -1.0F, 0.0F);
        leftrearleg.addChild(leftrearlegcombin);


        cube_r5 = new ModelPart(this);
        cube_r5.setPivot(-2.5F, 30.0F, 2.5F);
        leftrearlegcombin.addChild(cube_r5);
        setRotationAngle(cube_r5, 1.5708F, 0.0F, 0.0F);
        cube_r5.setTextureOffset(152, 29).addCuboid(-1.5F, -6.0F, 3.5F, 7.0F, 16.0F, 7.0F, 0.0F, false);

        leftrearfoot = new ModelPart(this);
        leftrearfoot.setPivot(-0.5F, 21.0F, 12.5F);
        leftrearlegcombin.addChild(leftrearfoot);
        setRotationAngle(leftrearfoot, 1.3963F, 0.0F, 0.0F);
        leftrearfoot.setTextureOffset(180, 29).addCuboid(-4.5F, 0.0F, -13.0F, 9.0F, 4.0F, 17.0F, 0.0F, false);

        leftrearfootD = new ModelPart(this);
        leftrearfootD.setPivot(0.0F, 3.0F, -12.0F);
        leftrearfoot.addChild(leftrearfootD);
        setRotationAngle(leftrearfootD, -1.2217F, 0.0F, 0.0F);
        leftrearfootD.setTextureOffset(215, 29).addCuboid(-4.5F, -2.0F, -7.0F, 9.0F, 4.0F, 7.0F, 0.0F, false);

        rightrearleg = new ModelPart(this);
        rightrearleg.setPivot(-11.0F, -5.0F, 23.5F);
        body.addChild(rightrearleg);
        setRotationAngle(rightrearleg, -0.192F, 0.2618F, 0.0F);
        rightrearleg.setTextureOffset(112, 29).addCuboid(-5.0F, 0.0F, -5.0F, 10.0F, 23.0F, 10.0F, 0.0F, true);

        rightrearlegcombin = new ModelPart(this);
        rightrearlegcombin.setPivot(0.0F, -1.0F, 0.0F);
        rightrearleg.addChild(rightrearlegcombin);


        cube_r6 = new ModelPart(this);
        cube_r6.setPivot(2.5F, 30.0F, 2.5F);
        rightrearlegcombin.addChild(cube_r6);
        setRotationAngle(cube_r6, 1.5708F, 0.0F, 0.0F);
        cube_r6.setTextureOffset(152, 29).addCuboid(-5.5F, -6.0F, 3.5F, 7.0F, 16.0F, 7.0F, 0.0F, true);

        rightrearfoot = new ModelPart(this);
        rightrearfoot.setPivot(0.5F, 21.0F, 12.5F);
        rightrearlegcombin.addChild(rightrearfoot);
        setRotationAngle(rightrearfoot, 1.3963F, 0.0F, 0.0F);
        rightrearfoot.setTextureOffset(180, 29).addCuboid(-4.5F, 0.0F, -13.0F, 9.0F, 4.0F, 17.0F, 0.0F, true);

        rightrearfootD = new ModelPart(this);
        rightrearfootD.setPivot(0.0F, 3.0F, -12.0F);
        rightrearfoot.addChild(rightrearfootD);
        setRotationAngle(rightrearfootD, -1.2217F, 0.0F, 0.0F);
        rightrearfootD.setTextureOffset(215, 29).addCuboid(-4.5F, -2.0F, -7.0F, 9.0F, 4.0F, 7.0F, 0.0F, true);

        rightwing = new ModelPart(this);
        rightwing.setPivot(0.0F, 0.0F, 0.0F);
        body.addChild(rightwing);


        rightwingpart1 = new ModelPart(this);
        rightwingpart1.setPivot(-25.0F, -10.0F, -20.0F);
        rightwing.addChild(rightwingpart1);
        rightwingpart1.setTextureOffset(0, 152).addCuboid(-14.0F, -3.0F, -3.0F, 28.0F, 6.0F, 6.0F, 0.0F, true);

        rightwingp1 = new ModelPart(this);
        rightwingp1.setPivot(25.0F, 41.0F, 22.0F);
        rightwingpart1.addChild(rightwingp1);
        rightwingp1.setTextureOffset(119, 235).addCuboid(-40.0F, -41.0F, -23.0F, 28.0F, 0.0F, 21.0F, 0.0F, false);

        rightwingpart2 = new ModelPart(this);
        rightwingpart2.setPivot(0.0F, 0.0F, 0.0F);
        rightwingpart1.addChild(rightwingpart2);
        rightwingpart2.setTextureOffset(0, 165).addCuboid(-62.0F, -2.0F, -2.0F, 48.0F, 4.0F, 4.0F, 0.0F, false);

        rightwingpart3 = new ModelPart(this);
        rightwingpart3.setPivot(-62.0F, 0.0F, 0.0F);
        rightwingpart2.addChild(rightwingpart3);
        setRotationAngle(rightwingpart3, 0.0F, 0.1745F, 0.0F);
        rightwingpart3.setTextureOffset(0, 172).addCuboid(-70.0F, -1.0F, -1.0F, 70.0F, 2.0F, 2.0F, 0.0F, false);

        rightwingp2 = new ModelPart(this);
        rightwingp2.setPivot(0.0F, 0.0F, 0.0F);
        rightwingpart3.addChild(rightwingp2);
        rightwingp2.setTextureOffset(-48, 178).addCuboid(-69.0F, 0.0F, -1.0F, 70.0F, 0.0F, 48.0F, 0.0F, false);

        rightwingpart4 = new ModelPart(this);
        rightwingpart4.setPivot(-62.0F, 0.0F, 0.0F);
        rightwingpart2.addChild(rightwingpart4);
        setRotationAngle(rightwingpart4, 0.0F, 0.9599F, 0.0F);
        rightwingpart4.setTextureOffset(0, 172).addCuboid(-70.0F, -1.0F, -1.0F, 70.0F, 2.0F, 2.0F, 0.0F, false);

        rightwingp3 = new ModelPart(this);
        rightwingp3.setPivot(0.0F, 0.0F, 0.0F);
        rightwingpart4.addChild(rightwingp3);
        rightwingp3.setTextureOffset(-48, 178).addCuboid(-69.0F, 0.0F, -1.0F, 70.0F, 0.0F, 48.0F, 0.0F, false);

        rightwingpart5 = new ModelPart(this);
        rightwingpart5.setPivot(-62.0F, 0.0F, 0.0F);
        rightwingpart2.addChild(rightwingpart5);
        setRotationAngle(rightwingpart5, 0.0F, 1.7453F, 0.0F);
        rightwingpart5.setTextureOffset(0, 172).addCuboid(-70.0F, -1.0F, -1.0F, 70.0F, 2.0F, 2.0F, 0.0F, false);

        rightwingp4 = new ModelPart(this);
        rightwingp4.setPivot(0.0F, 0.0F, 0.0F);
        rightwingpart5.addChild(rightwingp4);
        rightwingp4.setTextureOffset(-48, 178).addCuboid(-69.0F, 0.0F, -1.0F, 70.0F, 0.0F, 48.0F, 0.0F, false);

        rightwingpart6 = new ModelPart(this);
        rightwingpart6.setPivot(-62.0F, 0.0F, 0.0F);
        rightwingpart2.addChild(rightwingpart6);
        setRotationAngle(rightwingpart6, 0.0F, 2.5307F, 0.0F);
        rightwingpart6.setTextureOffset(0, 172).addCuboid(-70.0F, -1.0F, -1.0F, 70.0F, 2.0F, 2.0F, 0.0F, false);

        rightwingp5 = new ModelPart(this);
        rightwingp5.setPivot(0.0F, 0.0F, 0.0F);
        rightwingpart6.addChild(rightwingp5);
        rightwingp5.setTextureOffset(-26, 230).addCuboid(-69.0F, 0.0F, -1.0F, 70.0F, 0.0F, 26.0F, 0.0F, false);

        leftwing = new ModelPart(this);
        leftwing.setPivot(0.0F, 0.0F, 0.0F);
        body.addChild(leftwing);


        leftwingpart1 = new ModelPart(this);
        leftwingpart1.setPivot(25.0F, -10.0F, -20.0F);
        leftwing.addChild(leftwingpart1);
        leftwingpart1.setTextureOffset(0, 152).addCuboid(-14.0F, -3.0F, -3.0F, 28.0F, 6.0F, 6.0F, 0.0F, false);

        leftwingp1 = new ModelPart(this);
        leftwingp1.setPivot(-25.0F, 41.0F, 22.0F);
        leftwingpart1.addChild(leftwingp1);
        leftwingp1.setTextureOffset(119, 235).addCuboid(12.0F, -41.0F, -23.0F, 28.0F, 0.0F, 21.0F, 0.0F, true);

        leftwingpart2 = new ModelPart(this);
        leftwingpart2.setPivot(0.0F, 0.0F, 0.0F);
        leftwingpart1.addChild(leftwingpart2);
        leftwingpart2.setTextureOffset(0, 165).addCuboid(14.0F, -2.0F, -2.0F, 48.0F, 4.0F, 4.0F, 0.0F, true);

        leftwingpart3 = new ModelPart(this);
        leftwingpart3.setPivot(62.0F, 0.0F, 0.0F);
        leftwingpart2.addChild(leftwingpart3);
        setRotationAngle(leftwingpart3, 0.0F, -0.1745F, 0.0F);
        leftwingpart3.setTextureOffset(0, 172).addCuboid(0.0F, -1.0F, -1.0F, 70.0F, 2.0F, 2.0F, 0.0F, true);

        leftwingp2 = new ModelPart(this);
        leftwingp2.setPivot(0.0F, 0.0F, 0.0F);
        leftwingpart3.addChild(leftwingp2);
        leftwingp2.setTextureOffset(-48, 178).addCuboid(-1.0F, 0.0F, -1.0F, 70.0F, 0.0F, 48.0F, 0.0F, true);

        leftwingpart4 = new ModelPart(this);
        leftwingpart4.setPivot(62.0F, 0.0F, 0.0F);
        leftwingpart2.addChild(leftwingpart4);
        setRotationAngle(leftwingpart4, 0.0F, -0.9599F, 0.0F);
        leftwingpart4.setTextureOffset(0, 172).addCuboid(0.0F, -1.0F, -1.0F, 70.0F, 2.0F, 2.0F, 0.0F, true);

        leftwingp3 = new ModelPart(this);
        leftwingp3.setPivot(0.0F, 0.0F, 0.0F);
        leftwingpart4.addChild(leftwingp3);
        leftwingp3.setTextureOffset(-48, 178).addCuboid(-1.0F, 0.0F, -1.0F, 70.0F, 0.0F, 48.0F, 0.0F, true);

        leftwingpart5 = new ModelPart(this);
        leftwingpart5.setPivot(62.0F, 0.0F, 0.0F);
        leftwingpart2.addChild(leftwingpart5);
        setRotationAngle(leftwingpart5, 0.0F, -1.7453F, 0.0F);
        leftwingpart5.setTextureOffset(0, 172).addCuboid(0.0F, -1.0F, -1.0F, 70.0F, 2.0F, 2.0F, 0.0F, true);

        leftwingp4 = new ModelPart(this);
        leftwingp4.setPivot(0.0F, 0.0F, 0.0F);
        leftwingpart5.addChild(leftwingp4);
        leftwingp4.setTextureOffset(-48, 178).addCuboid(-1.0F, 0.0F, -1.0F, 70.0F, 0.0F, 48.0F, 0.0F, true);

        leftwingpart6 = new ModelPart(this);
        leftwingpart6.setPivot(62.0F, 0.0F, 0.0F);
        leftwingpart2.addChild(leftwingpart6);
        setRotationAngle(leftwingpart6, 0.0F, -2.5307F, 0.0F);
        leftwingpart6.setTextureOffset(0, 172).addCuboid(0.0F, -1.0F, -1.0F, 70.0F, 2.0F, 2.0F, 0.0F, true);

        leftwingp5 = new ModelPart(this);
        leftwingp5.setPivot(0.0F, 0.0F, 0.0F);
        leftwingpart6.addChild(leftwingp5);
        leftwingp5.setTextureOffset(-26, 230).addCuboid(-1.0F, 0.0F, -1.0F, 70.0F, 0.0F, 26.0F, 0.0F, true);
    }

    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //previously the render function, render code was moved to a method below

    }



    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }

	@Override
    public void render(MatrixStack matrixStack, VertexConsumer	buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
    }
}