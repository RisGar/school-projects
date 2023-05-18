defmodule Mix.Tasks.Predict do
  @moduledoc """
  Speist ein zufälliges Bild aus dem Datensatz in das neurale Netz ein.
  """

  use Mix.Task

  @requirements ["app.start", "app.config"]

  import ElixirNeuralNetwork

  @doc """
  Holt sich ein zufälliges Bild aus dem Datensatz und speist es in das neurale Netz ein.

  Der tranierte Zustand wird aus der Datei "state.axon" geladen, um damit die Zahl auf dem Bild vorherzusagen.
  """
  @impl Mix.Task
  def run(_) do
    {raw_images, _} = download()

    images = prepare_images(raw_images)

    model = build()
    state = load_state!("cache/state.axon")

    sample =
      images
      |> Nx.slice_along_axis(:rand.uniform(Nx.shape(images) |> elem(0)), 1)

    display_image(sample)

    prediction = predict(model, state, sample)

    IO.puts("Prediction: #{Nx.to_number(prediction)}")

    :ok
  end
end
