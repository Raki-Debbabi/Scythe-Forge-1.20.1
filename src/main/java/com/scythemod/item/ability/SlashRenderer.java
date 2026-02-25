package com.scythemod.item.ability;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.scythemod.Scythe;
import com.scythemod.item.SlashModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;

public class SlashRenderer extends EntityRenderer<SlashProjectileEntity> {

    private final SlashModel model;

    public SlashRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new SlashModel(context.bakeLayer(SlashModel.LAYER_LOCATION));
    }

    @Override
    public void render(SlashProjectileEntity entity, float entityYaw, float partialTicks,
                       PoseStack poseStack, MultiBufferSource buffer,
                       int packedLight) {

        poseStack.pushPose();

        // Rotate to match entity direction
        Vec3 motion = entity.getDeltaMovement();
        float yaw = (float)(Math.atan2(motion.x, motion.z) * (180F / Math.PI));
        poseStack.mulPose(Axis.YP.rotationDegrees(yaw));

        VertexConsumer vertexconsumer =
                buffer.getBuffer(RenderType.entityCutout(getTextureLocation(entity)));

        model.renderToBuffer(
                poseStack,
                vertexconsumer,
                packedLight,
                OverlayTexture.NO_OVERLAY,
                1f, 1f, 1f, 1f
        );

        poseStack.popPose();

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(SlashProjectileEntity entity) {
        return new ResourceLocation(Scythe.MODID, "textures/entity/slash.png");
    }
}
