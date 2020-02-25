package com.oroarmor.core.game;

import org.joml.Vector2f;
import org.joml.Vector3f;

public abstract class PhysicsEntity extends Entity {

	protected float weight = 0;

	protected Vector3f velocityVector;
	protected Vector3f accelerationVector;

	public PhysicsEntity(Vector3f position, Vector3f rotation, Vector3f scale, float weight) {
		super(position, rotation, scale);
		velocityVector = new Vector3f();
		accelerationVector = new Vector3f();
		this.weight = weight;
	}

	public Vector3f getVelocityVector() {
		return velocityVector;
	}

	public void setVelocityVector(Vector3f velocityVector) {
		this.velocityVector = velocityVector;
	}

	public Vector3f getAccelerationVector() {
		return accelerationVector;
	}

	public void setAccelerationVector(Vector3f accelerationVector) {
		this.accelerationVector = accelerationVector;
	}

	public void addForce(Vector3f force) {
		this.accelerationVector.add(force.div(weight));
	}

	public void addAcceleration(Vector3f acceleration) {
		this.accelerationVector.add(acceleration);
	}

	public void accelerateLocalXZ(Vector2f xzAcceleration) {
		this.addAcceleration(new Vector3f(
				xzAcceleration.x * (float) Math.cos(rotationVector.y)
						+ xzAcceleration.y * (float) Math.cos(Math.PI / 2 + rotationVector.y), //
				0, //
				xzAcceleration.x * (float) Math.sin(rotationVector.y)
						+ xzAcceleration.y * (float) Math.sin(Math.PI / 2 + rotationVector.y)//
		));
	}

	@Override
	public void tick(float delta) {
		super.tick(delta);

		velocityVector.add(accelerationVector.mul(delta, new Vector3f()));
		positionVector.add(velocityVector);

		accelerationVector.zero();
	}

}
