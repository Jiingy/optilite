package net.jineric.optilite.mixin.options.toggle;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.jineric.optilite.client.option.GameOptionsOL;
import net.minecraft.client.render.*;
import net.minecraft.resource.SynchronousResourceReloader;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(WorldRenderer.class)
public abstract class SunMoonToggleMixin implements SynchronousResourceReloader, AutoCloseable {
   // SUN
   @WrapOperation(
           method = "renderSky(Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V",
           at = @At(
                   value = "INVOKE",
                   target = "Lnet/minecraft/client/render/BufferBuilder;vertex(Lorg/joml/Matrix4f;FFF)Lnet/minecraft/client/render/VertexConsumer;",
                   ordinal = 2
           )
   )
   private VertexConsumer canSpecifySunPosVertex00(BufferBuilder instance, Matrix4f matrix4f, float x, float y, float z, Operation<VertexConsumer> original) {
      if (!GameOptionsOL.getSunMoon().getValue()) {
         return instance.vertex(matrix4f, 0, 0, 0);
      }
      return original.call(instance, matrix4f, x, y, z);
   }

   @WrapOperation(
           method = "renderSky(Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V",
           at = @At(
                   value = "INVOKE",
                   target = "Lnet/minecraft/client/render/BufferBuilder;vertex(Lorg/joml/Matrix4f;FFF)Lnet/minecraft/client/render/VertexConsumer;",
                   ordinal = 3
           )
   )
   private VertexConsumer canSpecifySunPosVertex10(BufferBuilder instance, Matrix4f matrix4f, float x, float y, float z, Operation<VertexConsumer> original) {
      if (!GameOptionsOL.getSunMoon().getValue()) {
         return instance.vertex(matrix4f, 0, 0, 0);
      }
      return original.call(instance, matrix4f, x, y, z);
   }

   @WrapOperation(
           method = "renderSky(Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V",
           at = @At(
                   value = "INVOKE",
                   target = "Lnet/minecraft/client/render/BufferBuilder;vertex(Lorg/joml/Matrix4f;FFF)Lnet/minecraft/client/render/VertexConsumer;",
                   ordinal = 4
           )
   )
   private VertexConsumer canSpecifySunPosVertex11(BufferBuilder instance, Matrix4f matrix4f, float x, float y, float z, Operation<VertexConsumer> original) {
      if (!GameOptionsOL.getSunMoon().getValue()) {
         return instance.vertex(matrix4f, 0, 0, 0);
      }
      return original.call(instance, matrix4f, x, y, z);
   }

   @WrapOperation(
           method = "renderSky(Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V",
           at = @At(
                   value = "INVOKE",
                   target = "Lnet/minecraft/client/render/BufferBuilder;vertex(Lorg/joml/Matrix4f;FFF)Lnet/minecraft/client/render/VertexConsumer;",
                   ordinal = 5
           )
   )
   private VertexConsumer canSpecifySunPosVertex01(BufferBuilder instance, Matrix4f matrix4f, float x, float y, float z, Operation<VertexConsumer> original) {
      if (!GameOptionsOL.getSunMoon().getValue()) {
         return instance.vertex(matrix4f, 0, 0, 0);
      }
      return original.call(instance, matrix4f, x, y, z);
   }

   // MOON
   @WrapOperation(
           method = "renderSky(Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V",
           at = @At(
                   value = "INVOKE",
                   target = "Lnet/minecraft/client/render/BufferBuilder;vertex(Lorg/joml/Matrix4f;FFF)Lnet/minecraft/client/render/VertexConsumer;",
                   ordinal = 6
           )
   )
   private VertexConsumer canSpecifyMoonPosVertex00(BufferBuilder instance, Matrix4f matrix4f, float x, float y, float z, Operation<VertexConsumer> original) {
      if (!GameOptionsOL.getSunMoon().getValue()) {
         return instance.vertex(matrix4f, 0, 0, 0);
      }
      return original.call(instance, matrix4f, x, y, z);
   }

   @WrapOperation(
           method = "renderSky(Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V",
           at = @At(
                   value = "INVOKE",
                   target = "Lnet/minecraft/client/render/BufferBuilder;vertex(Lorg/joml/Matrix4f;FFF)Lnet/minecraft/client/render/VertexConsumer;",
                   ordinal = 7
           )
   )
   private VertexConsumer canSpecifyMoonPosVertex10(BufferBuilder instance, Matrix4f matrix4f, float x, float y, float z, Operation<VertexConsumer> original) {
      if (!GameOptionsOL.getSunMoon().getValue()) {
         return instance.vertex(matrix4f, 0, 0, 0);
      }
      return original.call(instance, matrix4f, x, y, z);
   }

   @WrapOperation(
           method = "renderSky(Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V",
           at = @At(
                   value = "INVOKE",
                   target = "Lnet/minecraft/client/render/BufferBuilder;vertex(Lorg/joml/Matrix4f;FFF)Lnet/minecraft/client/render/VertexConsumer;",
                   ordinal = 8
           )
   )
   private VertexConsumer canSpecifyMoonPosVertex11(BufferBuilder instance, Matrix4f matrix4f, float x, float y, float z, Operation<VertexConsumer> original) {
      if (!GameOptionsOL.getSunMoon().getValue()) {
         return instance.vertex(matrix4f, 0, 0, 0);
      }
      return original.call(instance, matrix4f, x, y, z);
   }

   @WrapOperation(
           method = "renderSky(Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V",
           at = @At(
                   value = "INVOKE",
                   target = "Lnet/minecraft/client/render/BufferBuilder;vertex(Lorg/joml/Matrix4f;FFF)Lnet/minecraft/client/render/VertexConsumer;",
                   ordinal = 9
           )
   )
   private VertexConsumer canSpecifyMoonPosVertex01(BufferBuilder instance, Matrix4f matrix4f, float x, float y, float z, Operation<VertexConsumer> original) {
      if (!GameOptionsOL.getSunMoon().getValue()) {
         return instance.vertex(matrix4f, 0, 0, 0);
      }
      return original.call(instance, matrix4f, x, y, z);
   }

//   /**
//    * @author
//    * @reason
//    */
//   @Overwrite
//   public void renderSky(Matrix4f matrix4f, Matrix4f projectionMatrix, float tickDelta, Camera camera, boolean thickFog, Runnable fogCallback) {
//      fogCallback.run();
//      if (!thickFog) {
//         CameraSubmersionType cameraSubmersionType = camera.getSubmersionType();
//         if (cameraSubmersionType != CameraSubmersionType.POWDER_SNOW && cameraSubmersionType != CameraSubmersionType.LAVA && !this.hasBlindnessOrDarkness(camera)) {
//            MatrixStack matrixStack = new MatrixStack();
//            matrixStack.multiplyPositionMatrix(matrix4f);
//            if (this.client.world.getDimensionEffects().getSkyType() == DimensionEffects.SkyType.END) {
//               this.renderEndSky(matrixStack);
//            } else if (this.client.world.getDimensionEffects().getSkyType() == DimensionEffects.SkyType.NORMAL) {
//               Vec3d vec3d = this.world.getSkyColor(this.client.gameRenderer.getCamera().getPos(), tickDelta);
//               float f = (float)vec3d.x;
//               float g = (float)vec3d.y;
//               float h = (float)vec3d.z;
//               BackgroundRenderer.applyFogColor();
//               Tessellator tessellator = Tessellator.getInstance();
//               RenderSystem.depthMask(false);
//               RenderSystem.setShaderColor(f, g, h, 1.0F);
//               ShaderProgram shaderProgram = RenderSystem.getShader();
//               this.lightSkyBuffer.bind();
//               this.lightSkyBuffer.draw(matrixStack.peek().getPositionMatrix(), projectionMatrix, shaderProgram);
//               VertexBuffer.unbind();
//               RenderSystem.enableBlend();
//               float[] fs = this.world.getDimensionEffects().getFogColorOverride(this.world.getSkyAngle(tickDelta), tickDelta);
//               if (fs != null) {
//                  RenderSystem.setShader(GameRenderer::getPositionColorProgram);
//                  RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
//                  matrixStack.push();
//                  matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
//                  float i = MathHelper.sin(this.world.getSkyAngleRadians(tickDelta)) < 0.0F ? 180.0F : 0.0F;
//                  matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(i));
//                  matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90.0F));
//                  float j = fs[0];
//                  float k = fs[1];
//                  float l = fs[2];
//                  Matrix4f matrix4f2 = matrixStack.peek().getPositionMatrix();
//                  BufferBuilder bufferBuilder = tessellator.begin(VertexFormat.DrawMode.TRIANGLE_FAN, VertexFormats.POSITION_COLOR);
//                  bufferBuilder.vertex(matrix4f2, 0.0F, 100.0F, 0.0F).color(j, k, l, fs[3]);
//                  int m = 16;
//
//                  for(int n = 0; n <= 16; ++n) {
//                     float o = (float)n * (float) (Math.PI * 2) / 16.0F;
//                     float p = MathHelper.sin(o);
//                     float q = MathHelper.cos(o);
//                     bufferBuilder.vertex(matrix4f2, p * 120.0F, q * 120.0F, -q * 40.0F * fs[3]).color(fs[0], fs[1], fs[2], 0.0F);
//                  }
//
//                  BufferRenderer.drawWithGlobalProgram(bufferBuilder.end());
//                  matrixStack.pop();
//               }
//
//               RenderSystem.blendFuncSeparate(
//                       GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE, GlStateManager.SrcFactor.ONE, GlStateManager.DstFactor.ZERO
//               );
//
//
//
//               matrixStack.push();
//               float i = 1.0F - this.world.getRainGradient(tickDelta);
//               RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, i);
//               matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90.0F));
//               matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(this.world.getSkyAngle(tickDelta) * 360.0F));
//               Matrix4f matrix4f3 = matrixStack.peek().getPositionMatrix();
//               float k = 30.0F;
//               RenderSystem.setShader(GameRenderer::getPositionTexProgram);
//               RenderSystem.setShaderTexture(0, SUN);
//               BufferBuilder bufferBuilder2 = tessellator.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
//               bufferBuilder2.vertex(matrix4f3, -k, 100.0F, -k).texture(0.0F, 0.0F);
//               bufferBuilder2.vertex(matrix4f3, k, 100.0F, -k).texture(1.0F, 0.0F);
//               bufferBuilder2.vertex(matrix4f3, k, 100.0F, k).texture(1.0F, 1.0F);
//               bufferBuilder2.vertex(matrix4f3, -k, 100.0F, k).texture(0.0F, 1.0F);
//               BufferRenderer.drawWithGlobalProgram(bufferBuilder2.end());
//               k = 20.0F;
//               RenderSystem.setShaderTexture(0, MOON_PHASES);
//               int r = this.world.getMoonPhase();
//               int s = r % 4;
//               int m = r / 4 % 2;
//               float t = (float)(s + 0) / 4.0F;
//               float o = (float)(m + 0) / 2.0F;
//               float p = (float)(s + 1) / 4.0F;
//               float q = (float)(m + 1) / 2.0F;
//               bufferBuilder2 = tessellator.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
//               bufferBuilder2.vertex(matrix4f3, -k, -100.0F, k).texture(p, q);
//               bufferBuilder2.vertex(matrix4f3, k, -100.0F, k).texture(t, q);
//               bufferBuilder2.vertex(matrix4f3, k, -100.0F, -k).texture(t, o);
//               bufferBuilder2.vertex(matrix4f3, -k, -100.0F, -k).texture(p, o);
//               BufferRenderer.drawWithGlobalProgram(bufferBuilder2.end());
//               float u = this.world.getStarBrightness(tickDelta) * i;
//               if (u > 0.0F) {
//                  RenderSystem.setShaderColor(u, u, u, u);
//                  BackgroundRenderer.clearFog();
//                  this.starsBuffer.bind();
//                  this.starsBuffer.draw(matrixStack.peek().getPositionMatrix(), projectionMatrix, GameRenderer.getPositionProgram());
//                  VertexBuffer.unbind();
//                  fogCallback.run();
//               }
//               RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
//               RenderSystem.disableBlend();
//               RenderSystem.defaultBlendFunc();
//               matrixStack.pop();
//
//
//
//               RenderSystem.setShaderColor(0.0F, 0.0F, 0.0F, 1.0F);
//               double d = this.client.player.getCameraPosVec(tickDelta).y - this.world.getLevelProperties().getSkyDarknessHeight(this.world);
//               if (d < 0.0) {
//                  matrixStack.push();
//                  matrixStack.translate(0.0F, 12.0F, 0.0F);
//                  this.darkSkyBuffer.bind();
//                  this.darkSkyBuffer.draw(matrixStack.peek().getPositionMatrix(), projectionMatrix, shaderProgram);
//                  VertexBuffer.unbind();
//                  matrixStack.pop();
//               }
//
//               RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
//               RenderSystem.depthMask(true);
//            }
//         }
//      }
//   }
}
