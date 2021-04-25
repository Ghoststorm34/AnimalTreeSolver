package model;

/**
 * Models a response to the animal guessing game question.
 * 
 * @author Alexander Ayers
 * @version Spring 2021
 *
 */
public class Response {

	private static final String RESPONSE_CANNOT_BE_NULL = "Response cannot be null.";
	private static final String TYPE_CANNOT_BE_NULL = "Type cannot be null.";
	private static final String VALUE_CANNOT_BE_NULL = "Value cannot be null.";
	
	private String value;
	private ResponseType type;

	/**
	 * Instantiates a new response.
	 *
	 * @precondition value != null && type != null
	 * @postcondition getValue() == value && getType() == type
	 *
	 * @param value the value
	 * @param type  the type
	 */
	public Response(String value, ResponseType type) {
		if (value.equals(null)) {
			throw new IllegalArgumentException(VALUE_CANNOT_BE_NULL);
		}
		if (type.equals(null)) {
			throw new IllegalArgumentException(TYPE_CANNOT_BE_NULL);
		}

		this.value = value;
		this.type = type;
	}

	/**
	 * Gets the value.
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Gets the type.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the type
	 */
	public ResponseType getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object response) {
		if (response == null) {
			throw new IllegalArgumentException(RESPONSE_CANNOT_BE_NULL);
		}
		return ((Response) response).getValue().equals(this.value) && ((Response) response).getType().equals(this.type);
	}
}
